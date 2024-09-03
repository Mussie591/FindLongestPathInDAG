import java.util.Map;

public class Main {

    public static void main(String[] args) {
        LongestPathInDAG.Graph graph = new LongestPathInDAG.Graph();

        Vertex v0 = graph.addVertex(0);
        Vertex v1 = graph.addVertex(1);
        Vertex v2 = graph.addVertex(2);
        Vertex v3 = graph.addVertex(3);
        Vertex v4 = graph.addVertex(4);
        Vertex v5 = graph.addVertex(5);
        Vertex v6 = graph.addVertex(6);
        Vertex v7 = graph.addVertex(7);

        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);

        System.out.println(graph);

        Map<Vertex, Integer> longestPath = LongestPathInDAG.findLongestPath(graph, v0);
        for (Map.Entry<Vertex, Integer> entry : longestPath.entrySet()) {
            System.out.println("Vertex(" + entry.getKey().id + ") longest path = " + entry.getValue());
        }
    }
}

