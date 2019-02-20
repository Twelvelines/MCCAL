package mccal.model;

import mccal.exceptions.ForeignComponentException;
import java.util.*;

/**
 * A class for an epistemic model.
 */
// TODO rearrange methods
public class Model {
    private int numAgents;    // they are named by index, conventionally starting from 1
    private Set<String> states = new HashSet<>();    // all states in the model
    // maps every proposition to the set of states where it is true
    // TODO distinguish atom and proposition
    private Map<String, Set<String>> atoms = new HashMap<>();
    // represents the epistemic relations via mapping every agent to a list of equivalence classes which are sets of
    // indistinct states for the agent
    private Map<Integer, List<Set<String>>> equivRels = new HashMap<>();

    public Model() {
    }

    /**
     * Constructor with number of agents.
     */
    public Model(int n) {
        this.numAgents = n;
    }

    public static Set<String> intersect(Set<String> a, Set<String> b) {
        Set<String> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Number of agents: ").append(numAgents).append("\n");
        result.append("States:\n").append(stringArrangeStates(states, 4, 0)).append("\n");
        result.append("Equivalences:\n");
        for (int agent = 1; agent <= numAgents; agent++) {
            result.append("For Agent ").append(agent).append(" ");
            List<Set<String>> equivs = equivRels.get(agent);
            int equivsSize = equivs.size();
            for (int i = 0; i < equivsSize; i++) {
                result.append("{\n");
                result.append(stringArrangeStates(equivs.get(i), 3, 1));
                result.append(i == equivsSize - 1 ? "}\n" : "} and ");
            }
        }
        return result.toString();
    }

    private String stringArrangeStates(Set<String> sSet, int column, int indentNum) {
        StringBuilder result = new StringBuilder();
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < indentNum; i++) {
            indent.append("\t");
        }
        int sSize = sSet.size();
        int i = 0;
        for (String s : sSet) {
            i++;
            result.append(indent).append(s).append(i == sSize ? "" : ",").append(i % column == 0 ? "\n" : "\t");
        }
        if (sSize % 8 != 0)
            result.append("\n");
        return result.toString();
    }

    /**
     * Bisimulation contraction of the model.
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
            // TODO state concat (not easy)
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
     * Gets intersections on all pairs of strategies for all agents.
     * TODO revise on throwing this exception - maybe only evaluator should throw, or maybe other methods in model should as well
     */
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
            for (int j = i+1; j < sizeAgentlist; j++) {
                // TODO concise the code
                Set<Set<String>> strats = getStrategies(realState, agentlist.get(i));
                for (Set<String> stratI : strats) {
                    Set<Set<String>> strats2 = getStrategies(realState, agentlist.get(j));
                    for (Set<String> stratJ : strats2) {
                        allStrats.add(intersect(stratI, stratJ));
                    }
                }
            }
        }
        return allStrats;
    }

    // Set the number of agents
    public void setNumberOfAgents(int n) {
        if (numAgents != 0) {
            System.err.print("Model: Number of agent already set\n");
            return;
        }
        numAgents = n;
        while (n != 0) {
            equivRels.put(n, new ArrayList<>());
            n--;
        }
    }

    // add a global state to the map.
    // TODO: fail if we try to add an existing state? For the moment
    // we just ignore existing states.
    public void addGlobalState(String id) {
        if (!states.contains(id)) {
            states.add(id);
        }
    }

    // add a relation to the equiv. sets
    // state 1 and 2 are a pair of indistinguishable states specified in input model file
    // the two states are possibly identical, thus no need for any state to be added
    public void addRelation(Integer agent, String state1, String state2) {
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


    // Add an atom to the set of atoms.
    // TODO: as above, we ignore repeated atoms for the moment.
    public void addAtoms(String atom, Set<String> states) {
        if (!atoms.containsKey(atom)) {
            atoms.put(atom, states);
        }
    }


    // Simple getters
    public int getNumberOfAgents() {
        return numAgents;
    }

    public Set<String> getAllStates() {
        return states;
    }

    public Map<String, Set<String>> getAtoms() {
        return atoms;
    }

    public Map<Integer, List<Set<String>>> getEquivs() {
        return equivRels;
    }

    public List<Set<String>> getEquivClasses(int agent) {
        // TODO: Add error checking on i
        return equivRels.get(agent);
    }


    // Get the set of states in which an atom is true
    // TODO: we return null if the atom doesn't exist. This is probably OK
    public Set<String> getStatesWhereTrue(String atom) {
        if (atoms.containsKey(atom)) {
            return atoms.get(atom);
        }
        return null;
    }


    // foreign state resilient
    public Set<String> getEquivStates(int agent, Set<String> theStates) throws ForeignComponentException {
        Set<String> union = new HashSet<>();
        List<Set<String>> eqClasses = equivRels.get(agent);
        if (eqClasses == null) {
            throw new ForeignComponentException("Error: foreign agent (not existing in the model)");
        }
        for (Set<String> aClass : eqClasses) {
            if (!intersect(aClass, theStates).isEmpty())
                union.addAll(aClass);
        }
        return union;
    }


    // Returns the set of global states epistemically equivalent to state for agent
    public Set<String> getEquivStates(int agent, String state) throws ForeignComponentException {
        // We get the eq. classes for this agent:
        List<Set<String>> eqClasses = equivRels.get(agent);
        if (eqClasses == null) {
            throw new ForeignComponentException("Error: foreign agent (not existing in the model)");
        }

        // We iterate over the classes to see if there is one that
        // contains the state
        for (Set<String> aClass : eqClasses) {
            if (aClass.contains(state)) {
                return aClass;
            }
        }
        throw new ForeignComponentException("Error: foreign state (not existing in the model)");
    }


    // Get a new model shrunk from the original one based on specified valid states
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
        Model shrunk = new Model();
        shrunk.numAgents = numAgents;
        shrunk.states = new HashSet<>(validStates);
        shrunk.atoms = shrunkAtoms;
        shrunk.equivRels = shrunkEquivRels;
        return shrunk;
    }

}
