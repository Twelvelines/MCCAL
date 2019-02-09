package mccal.model;

import mccal.exceptions.ForeignComponentException;
import java.util.*;

/**
 * A class for an epistemic model.
 */
public class Model {
    private int numAgents;    // they are named by index
    private List<String> states = new ArrayList<>();    // all states in the model
    // maps every proposition to the set of states where it is true
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

    /**
     * Be noted that returned references are all to the states and equiv sets in the model, not copies.
     * TODO are they?
     */
    public Set<Set<String>> getStrategies(String realState, int agent) throws ForeignComponentException {
        Set<Set<String>> strategies = new HashSet<>();
        Set<String> realClass = new HashSet<>(getEquivalentStates(agent, realState));
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
        int noAgentlist = agentlist.size();
        if (noAgentlist == 0) {
            return new HashSet<>();
        }
        if (noAgentlist == 1) {
            return getStrategies(realState, agentlist.get(0));
        }
        Set<Set<String>> allStrats = new HashSet<>();
        for (int i = 0; i < noAgentlist; i++) {
            for (int j = i+1; j < noAgentlist; j++) {
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

    public List<String> getAllStates() {
        return states;
    }

    public Map<String, Set<String>> getAtoms() {
        return atoms;
    }

    public Map<Integer, List<Set<String>>> getRK() {
        return equivRels;
    }

    public List<Set<String>> getEquivClasses(int agent) {
        // TODO: Add error checking on i
        return equivRels.get(agent);
    }

    // Get the tuple of local states for a given global state ID
    // TODO: we return null for non-existing id: shall we fail?
    public String getGlobalStateDetails(String id) {
        for (String s : states) {
            if (s.equals(id)) {
                return s;
            }
        }
        return null;
    }


    // Get the set of states in which an atom is true
    // TODO: we return null if the atom doesn't exist. This is probably OK
    public Set<String> getStatesWhereTrue(String atom) {
        if (atoms.containsKey(atom)) {
            return atoms.get(atom);
        }
        return null;
    }


    // Returns the set of global states epistemically equivalent to
    // aState for agent i
    public Set<String> getEquivalentStates(int agent, String aState) throws ForeignComponentException {
        // We get the eq. classes for this agent:
        List<Set<String>> eqClasses = equivRels.get(agent);
        if (eqClasses == null) {
            throw new ForeignComponentException("Error: foreign agent (not existing in the model)");
        }

        // We iterate over the classes to see if there is one that
        // contains aState
        for (Set<String> aClass : eqClasses) {
            if (aClass.contains(aState)) {
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
        shrunk.states = new ArrayList<>(validStates);
        shrunk.atoms = shrunkAtoms;
        shrunk.equivRels = shrunkEquivRels;
        return shrunk;
    }

    public void bisimulationContract() {
        // TODO
    }
}
