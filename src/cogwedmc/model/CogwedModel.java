package cogwedmc.model;

import java.util.*;

/* A class for a cogwed model, nothing special */
public class CogwedModel {

    // The number of agents in the model.
    private int numAgents;

    // The list of global states
    private List<String> gStates;

    // A map from the string to the set of states where the atom is true.
    private Map<String, Set<String>> atoms;

    // These are the epistemic relations.
    // The idea is that to each agent (identified by a number)
    // we associate a list of equivalence sets.
    private Map<Integer, List<Set<String>>> rk;

    // Standard constructor;
    public CogwedModel() {
        gStates = new ArrayList<>();
        atoms = new HashMap<>();
        rk = new HashMap<>();
    }

    // Constructor with number of agents
    public CogwedModel(int n) {
        this();
        this.numAgents = n;
    }

    // Set the number of agents
    public void setNumberOfAgents(int n) {
        if (n != 0) {
            System.err.print("CogwedModel: Number of agent already set\n");
            return;
        }
        numAgents = n;
    }

    // add a global state to the map.
    // TODO: fail if we try to add an existing state? For the moment
    // we just ignore existing states.
    public void addGlobalState(String id) {
        if (!gStates.contains(id)) {
            gStates.add(id);
        }
    }

    // add a single transition to the set of transitions
    public void addEdge(Integer agent, Set<String> edge) {
        rk.get(agent).add(edge);
    }

    // Add an atom to the set of atoms.
    // TODO: as above, we ignore repeated atoms for the moment.
    public void addAtom(String atom, Set<String> states) {
        if (!atoms.containsKey(atom)) {
            atoms.put(atom, states);
        }
    }


    // Simple getters
    public int getNumberOfAgents() {
        return numAgents;
    }

    public List<String> getAllStates() {
        return gStates;
    }

    public Map<String, Set<String>> getAtoms() {
        return atoms;
    }

    // Get the tuple of local states for a given global state ID
    // TODO: we return null for non-existing id: shall we fail?
    public String getGlobalStateDetails(String id) {
        for (String s : gStates) {
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
        } else {
            return null;
        }
    }


    /*
    // Get the successor states for a given source state
    // TODO: this could be implemented more efficiently (probably)
    // using a filter on an iterator
    public Set<String> getSuccessors(String source) {
        Set<String> result = new HashSet<String>();
        for (Edge st : edges) {
            if (st.getEdge1().equals(source)) {
                result.add(st.getEdge2());
            }
        }
        return result;
    }

    // Get the predecessor states for a given destination
    // TODO: probably using a filter on iterator is more efficient.
    public Set<String> getPredecessors(String destination) {
        Set<String> result = new HashSet<String>();
        for (Edge st : edges) {
            if (st.getEdge2().equals(destination)) {
                result.add(st.getEdge1());
            }
        }
        return result;
    }


    // Get the predecessor states for a list of states
    public Set<String> getPredecessors(Set<String> destinations) {

        Set<String> tmpResult = new HashSet<String>();

        // We iterate over all states
        // and we add the predecessors to tmpResult
        for (String aState : destinations) {
            tmpResult.addAll(this.getPredecessors(aState));
        }
        return tmpResult;
    }
    */


    /*
    // Returns the set of global states epistemically equivalent to
    // aState for agent i
    public Set<String> getEquivalentStates(int i, String aState) {
        // We get the eq. classes for this agent:
        List<Set<String>> eqClasses = rk.get(i);

        // We iterate over the classes to see if there is one that
        // contains aState
        for (Set<String> aClass : eqClasses) {
            if (aClass.contains(aState)) {
                return aClass;
            }
        }
        return null;
    }
    */

    /*
    public void setupModel() {
        // TODO: add some consistency checks here.
        // For the moment we just build the map rk.

        // we iterate over agents
        for (int i = 0; i < numAgents; i++) {

            // We start from the whole set of states and we split it
            Set<String> tmpGStates = new HashSet<>(gStates);
            List<Set<String>> eqClassesForAgent = new ArrayList<>();

            while (tmpGStates.size() > 0) {
                // we pick the "first" element and we compute its equivalence
                // class. To get an element, we convert the set to a
                // List (I couldn't find a better way...)
                List<String> listString = new ArrayList<>(tmpGStates);
                String aState = listString.get(0);
                Set<String> equivalenceClass = new HashSet<>();
                // Now we iterate over the remaining states and we
                // construct the equivalence class of the state at
                // position randomPos
                for (String gstate : tmpGStates) {
                    if ((this.getGlobalStateDetails
                            (aState).get(i)).equals
                            (this.getGlobalStateDetails(gstate).get(i))
                            ) {
                        // The i-th component of aState and gstate are
                        // the same: they should be in the same equiv. class
                        equivalenceClass.add(gstate);
                    }
                }

                // We add the equivalence class
                eqClassesForAgent.add(new HashSet<String>(equivalenceClass));
                // Now we remove the equivalence class from the set of
                // states we have to process
                tmpGStates.removeAll(equivalenceClass);
            } // end while to construct equiv. classes for agent i
            rk.put(i, new ArrayList<Set<String>>(eqClassesForAgent));
        } // end for loop over agents
    }
    */

}
