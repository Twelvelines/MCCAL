package mccal.model;

import mccal.exceptions.ForeignComponentException;
import java.util.*;

/**
 * A class for an epistemic model.
 */
// TODO rearrange methods
public class Model {
    private static int PRINT_STATES_COLUMNS = 10;

    private int numAgents;    // they are named by index, conventionally starting from 1
    private Set<String> states = new HashSet<>();    // all states in the model
    // maps every proposition to the set of states where it is true
    private Map<String, Set<String>> atoms = new HashMap<>();
    // represents the epistemic relations via mapping every agent to a list of equivalence classes which are sets of
    // indistinct states for the agent
    private Map<Integer, List<Set<String>>> equivRels = new HashMap<>();

    public Model(int numAgents) {
        this.numAgents = numAgents;
        while (numAgents != 0) {
            equivRels.put(numAgents, new ArrayList<>());
            numAgents--;
        }
    }

    public static <T> Set<T> intersect(Collection<Set<T>> sets) {
        Iterator<Set<T>> it = sets.iterator();
        if (!it.hasNext()) {
            return new HashSet<>();
        }
        Set<T> result = new HashSet<>(it.next());
        while (it.hasNext()) {
            result.retainAll(it.next());
        }
        return result;
    }

    public static <T> Set<T> intersect(Set<T> a, Set<T> b) {
        Set<T> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

    // TODO
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Number of agents: ").append(numAgents).append("\n")
                .append("States:").append(formatStateStrings(states, 0, false)).append("\n")
                .append("Equivalences:\n");
        for (int agent = 1; agent <= numAgents; agent++) {
            result.append("For Agent ").append(agent).append(" ");
            List<Set<String>> equivs = equivRels.get(agent);
            int equivsSize = equivs.size();
            for (int i = 0; i < equivsSize; i++) {
                Set<String> equiv = equivs.get(i);
                result.append("{")
                        .append(formatStateStrings(equiv, 1, true))
                        .append("}").append(i != equivsSize - 1 ? " and " : (agent != numAgents ? "\n" : ""));  // end of agent? end of all?
            }
        }
        return result.toString();
    }

    private String formatStateStrings(Set<String> sSet, int indentNum, boolean isNewlineEndForMultilines) {
        StringBuilder result = new StringBuilder();
        int sSize = sSet.size();
        if (sSize <= PRINT_STATES_COLUMNS) {
            result.append(" ").append(sSet).append(" ");
        } else {
            StringBuilder newlineindent = new StringBuilder("\n");
            for (int i = 0; i < indentNum; i++) {
                newlineindent.append("\t");
            }
            result.append(newlineindent);
            int i = 0;
            for (String s : sSet) {
                i++;
                // end ? nought : (end of line ? newline : continue the line)
                result.append(s).append(i == sSize ? "" : (i % PRINT_STATES_COLUMNS == 0 ? "," + newlineindent : ",\t"));
            }
            if (isNewlineEndForMultilines)
                result.append("\n");
        }
        return result.toString();
    }

    /**
     * Returns bisimulation contraction of the model.
     */
    public Model bisumContract() {
        Set<Set<String>> buckets = new HashSet<>();
        buckets.add(new HashSet<>(states));    // a copy of all states

        // partition by atoms
        for (Set<String> atomStates : atoms.values()) {
            splitBuckets(buckets, atomStates);
        }

        // partition by neighbors/equivalences/edges
        do {
            Set<Set<String>> postbuckets = new HashSet<>(buckets);
            for (Set<String> aPrebucket : buckets) {
                for (int i = 0; i < numAgents; i++) {
                    int agent = i + 1;
                    Set<String> equivStates;
                    try {
                        equivStates = getEquivStates(agent, aPrebucket);
                    } catch (ForeignComponentException e) {
                        // should not be happening, as the agent is from model's internal list
                        System.err.println(e.toString());
                        return null;
                    }
                    splitBuckets(postbuckets, equivStates);
                }
            }
            if (postbuckets.size() == buckets.size())
                break;
            buckets = postbuckets;
        } while (true);

        Set<String> union = new HashSet<>();
        for (Set<String> aBucket : buckets) {
            List<String> abList = new ArrayList<>(aBucket);
            // TODO state id concat (not easy)
            union.add(abList.get(0));
        }
        return getShrunkModel(union);
    }

    private void splitBuckets(Set<Set<String>> buckets, Set<String> compareBucket) {
        List<Set<String>> newBuckets = new ArrayList<>();
        List<Set<String>> oldBuckets = new ArrayList<>();
        for (Set<String> aBucket : buckets) {
            Set<String> conjunct = intersect(aBucket, compareBucket);
            Set<String> disjunct = new HashSet<>(aBucket);
            disjunct.removeAll(conjunct);
            if (!conjunct.isEmpty() && !disjunct.isEmpty()) {
                newBuckets.add(conjunct);
                newBuckets.add(disjunct);
                oldBuckets.add(aBucket);
            }
        }
        buckets.removeAll(oldBuckets);
        buckets.addAll(newBuckets);
    }

    /**
     * Be noted that returned references are all to the states and equiv sets in the model, not copies.
     * TODO are they?
     */
    public Set<Set<String>> getStrategies(String realState, int agent) throws ForeignComponentException {
        Set<Set<String>> strategies = new HashSet<>();
        Set<String> realClass = new HashSet<>(getEquivStates(agent, realState));
        strategies.add(realClass);
        // combination of the equiv classes left
        List<Set<String>> restOfClasses = new ArrayList<>(equivRels.get(agent));
        restOfClasses.remove(realClass);
        int rocSize = restOfClasses.size();
        for (int i = 0; i < rocSize; i++) {
            Set<String> stratI = new HashSet<>(realClass);
            stratI.addAll(restOfClasses.get(i));
            strategies.add(stratI);
            for (int j = i+1; j < rocSize; j++) {
                Set<String> prev = new HashSet<>(stratI);  // TODO revise
                for (int k = j; k < rocSize; k++) {
                    prev.addAll(restOfClasses.get(k));
                }
            }
        }
        return strategies;
    }

    /**
     * Returns intersections on all pairs of strategies for all agents.
     */
    public Set<Map<Integer, Set<String>>> getIndiStrategies(String realState, List<Integer> agentlist) throws ForeignComponentException {
        Set<Map<Integer, Set<String>>> result = new HashSet<>();
        int sizeAgentlist = agentlist.size();
        if (sizeAgentlist == 0)
            return result;
        if (sizeAgentlist == 1) {
            int agent = agentlist.get(0);
            Set<Set<String>> strats = getStrategies(realState, agent);
            for (Set<String> strat : strats) {
                Map<Integer, Set<String>> singleAgentStrat = new HashMap<>();
                singleAgentStrat.put(agent, strat);
                result.add(singleAgentStrat);
            }
            return result;
        }
        for (int i = 0; i < sizeAgentlist; i++) {
            Set<Set<String>> stratsI = getStrategies(realState, agentlist.get(i));
            for (int j = i+1; j < sizeAgentlist; j++) {
                // TODO optimisation?
                Set<Set<String>> stratsJ = getStrategies(realState, agentlist.get(j));
                for (Set<String> stratI : stratsI) {
                    for (Set<String> stratJ : stratsJ) {
                        Map<Integer, Set<String>> costrats = new HashMap<>();
                        costrats.put(agentlist.get(i), stratI);
                        costrats.put(agentlist.get(j), stratJ);
                        result.add(costrats);
                    }
                }
            }
        }
        return result;
    }

    public Set<Set<String>> getStrategies(String realState, List<Integer> agentlist) throws ForeignComponentException {
        int sizeAgentlist = agentlist.size();
        if (sizeAgentlist == 0) {
            return new HashSet<>();
        }
        if (sizeAgentlist == 1) {
            return getStrategies(realState, agentlist.get(0));
        }
        Set<Set<String>> allStrats = new HashSet<>();
        for (int i = 0; i < sizeAgentlist; i++) {
            Set<Set<String>> stratsI = getStrategies(realState, agentlist.get(i));
            for (int j = i+1; j < sizeAgentlist; j++) {
                Set<Set<String>> stratsJ = getStrategies(realState, agentlist.get(j));
                for (Set<String> stratI : stratsI) {
                    for (Set<String> stratJ : stratsJ) {
                        allStrats.add(intersect(stratI, stratJ));
                    }
                }
            }
        }
        return allStrats;
    }

    /**
     * Returns a new model shrunk from the original one based on specified valid states.
     */
    // TODO better algorithm to speed up the elimination of invalid states?
    public Model getShrunkModel(Set<String> validStates) {
        // first shallow copy
        Map<String, Set<String>> shrunkAtoms = new HashMap<>(atoms);
        Map<Integer, List<Set<String>>> shrunkEquivRels = new HashMap<>(equivRels);
        // deep copy and elimination for atoms
        List<Map.Entry<String, Set<String>>> regEmptyAtoms = new ArrayList<>();
        for (Map.Entry<String, Set<String>> atom : shrunkAtoms.entrySet()) {
            // implement deep copy
            Set<String> cloneSet = new HashSet<>(atom.getValue());
            atom.setValue(cloneSet);
            // do elimination
            cloneSet.retainAll(validStates);
            if (cloneSet.isEmpty()) {    // clear empty set after elimination
                regEmptyAtoms.add(atom);
            }
        }
        shrunkAtoms.entrySet().removeAll(regEmptyAtoms);
        // deep copy and elimination for equiv rels
        List<Map.Entry<Integer, List<Set<String>>>> regEmptyEquivRels = new ArrayList<>();
        for (Map.Entry<Integer, List<Set<String>>> equivRel : shrunkEquivRels.entrySet()) {
            // implement deep copy
            List<Set<String>> cloneList = new ArrayList<>(equivRel.getValue());
            equivRel.setValue(cloneList);
            List<Set<String>> regEmptySets = new ArrayList<>();
            int numSets = cloneList.size();
            for (int i = 0; i < numSets; i++) {
                // implement deep copy
                Set<String> cloneSet = new HashSet<>(cloneList.get(i));
                cloneList.set(i, cloneSet);
                // do elimination
                cloneSet.retainAll(validStates);
                if (cloneSet.isEmpty()) {    // clear empty set after elimination
                    regEmptySets.add(cloneSet);
                }
            }
            cloneList.removeAll(regEmptySets);
            if (cloneList.isEmpty()) {    // clear empty set after elimination
                regEmptyEquivRels.add(equivRel);
            }
        }
        shrunkEquivRels.entrySet().removeAll(regEmptyEquivRels);
        // setup shrunk model
        Model shrunk = new Model(numAgents);
        shrunk.states = new HashSet<>(validStates);
        shrunk.atoms = shrunkAtoms;
        shrunk.equivRels = shrunkEquivRels;
        return shrunk;
    }

    // getters

    public int getNumberOfAgents() {
        return numAgents;
    }

    public Set<String> getAllStates() {
        return new HashSet<>(states);
    }

    /**
     * Returns the set of states in which an atom is true.
     */
    public Set<String> getStates(String atom) {
        if (atoms.containsKey(atom))
            return new HashSet<>(atoms.get(atom));
        return new HashSet<>();
    }

    // TODO foreign agent?
    public List<Set<String>> getEquivClasses(int agent) {
        List<Set<String>> result = new ArrayList<>();
        if (equivRels.containsKey(agent)) {
            for (Set<String> aClass : equivRels.get(agent)) {
                result.add(new HashSet<>(aClass));
            }
        }
        return result;
    }

    // TODO foreign state resilient?
    public Set<String> getEquivStates(int agent, Set<String> theStates) throws ForeignComponentException {
        Set<String> result = new HashSet<>();
        List<Set<String>> eqClasses = equivRels.get(agent);
        if (eqClasses == null) {
            throw new ForeignComponentException("Error: foreign agent (not existing in the model)");
        }
        for (Set<String> aClass : eqClasses) {
            if (!intersect(aClass, theStates).isEmpty())
                result.addAll(aClass);
        }
        return result;
    }

    /**
     *  Returns the set of states epistemically equivalent to the one provided for agent.
     */
    public Set<String> getEquivStates(int agent, String state) throws ForeignComponentException {
        // get the equiv classes for this agent:
        List<Set<String>> eqClasses = equivRels.get(agent);
        if (eqClasses == null) {
            throw new ForeignComponentException("Error: foreign agent (not existing in the model)");
        }

        // iterate over the classes to find the one that contains the state
        for (Set<String> aClass : eqClasses) {
            if (aClass.contains(state)) {
                return new HashSet<>(aClass);
            }
        }
        throw new ForeignComponentException("Error: foreign state (not existing in the model)");
    }

    // setters

    // TODO if fail when try to add an existing state?
    public void addState(String id) {
        states.add(id);
    }

    public void addAtom(String atom, Set<String> states) {
        if (atoms.containsKey(atom)) {
            System.err.println("addAtom: atom already exists");
            return;
        }
        atoms.put(atom, states);
    }

    public void addEquivClass(int agent, Set<String> newClass) {
        List<Set<String>> classes = equivRels.get(agent);
        for (Set<String> c : classes) {
            if (!intersect(newClass, c).isEmpty()) {
                c.addAll(newClass);
                return;
            }
        }  // else
        classes.add(newClass);
    }

    /**
     * Adds a relation to the equiv map.
     * States 1 and 2 are a pair of indistinguishable states specified in input model file.
     * Sometimes the two states are identical, in which case no need for any state to be added.
     */
    public void addEquivRelation(Integer agent, String state1, String state2) {
        boolean belongingClusterFound = false;
        for (Set<String> equivSet : equivRels.get(agent)) {
            if (equivSet.contains(state1)) {
                if (!state1.equals(state2)) {
                    equivSet.add(state2);
                }
                belongingClusterFound = true;
                break;
            }
            if (equivSet.contains(state2)) {
                if (!state1.equals(state2)) {
                    equivSet.add(state1);
                }
                belongingClusterFound = true;
                break;
            }
        }
        if (!belongingClusterFound) {
            // add a brand new equiv. set
            Set<String> newSet = new HashSet<>();
            newSet.add(state1);
            if (!state1.equals(state2)) {
                newSet.add(state2);
            }
            equivRels.get(agent).add(newSet);
        }
    }

}
