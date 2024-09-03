public class Edge {
    Vertex from;
    Vertex to;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }
}
