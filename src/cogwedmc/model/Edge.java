package cogwedmc.model;

/* A simple class to encode a single transition from a edge1
   state to a edge2 state
*/
public class Edge {

    // Agents and states
    private int agent;
    private String edge1;
    private String edge2;

    public Edge(int a, String s, String d) {
        agent = a;
        edge1 = s;
        edge2 = d;
    }

    public int getAgent() { return agent; }

    public String getEdge1() {
        return edge1;
    }

    public String getEdge2() {
        return edge2;
    }

    public void setEdge1(String s) {
        edge1 = s;
    }

    public void setEdge2(String d) {
        edge2 = d;
    }

    // To compare to single transitions
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Edge)) return false;
        Edge st = (Edge) o;
        return this.edge1.equals(st.getEdge1()) &&
                this.edge2.equals(st.getEdge2());
    }
}
