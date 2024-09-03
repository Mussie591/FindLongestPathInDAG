import java.util.*;

public class LongestPathInDAG {
    public static class Graph {
        private Map<Vertex, List<Vertex>> adjacencyList;
        private Map<Long, Vertex> vertexMap;

        public Graph() {
            this.adjacencyList = new HashMap<>();
            this.vertexMap = new HashMap<>();
        }

        public Vertex addVertex(long id) {
            Vertex vertex = new Vertex(id);
            adjacencyList.putIfAbsent(vertex, new ArrayList<>());
            vertexMap.put(id, vertex);
            return vertex;
        }

        public void addEdge(long fromId, long toId) {
            Vertex from = vertexMap.get(fromId);
            Vertex to = vertexMap.get(toId);
            if (from == null || to == null) {
                throw new IllegalArgumentException("Vertex not found");
            }
            adjacencyList.get(from).add(to);
        }

        public List<Vertex> getAdjacencyList(Vertex vertex) {
            return adjacencyList.get(vertex);
        }

        public Collection<Vertex> getVertices() {
            return adjacencyList.keySet();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Vertex vertex : adjacencyList.keySet()) {
                sb.append(vertex).append(" -> ").append(adjacencyList.get(vertex)).append("\n");
            }
            return sb.toString();
        }
    }

    public static Map<Vertex, Integer> findLongestPath(Graph graph, Vertex startVertex) {
        List<Vertex> topologicalOrder = topologicalSort(graph);
        Map<Vertex, Integer> longestPath = new HashMap<>();

        for (Vertex vertex : topologicalOrder) {
            longestPath.put(vertex, Integer.MIN_VALUE);
        }

        longestPath.put(startVertex, 0);

        for (Vertex vertex : topologicalOrder) {
            if (longestPath.get(vertex) != Integer.MIN_VALUE) {
                for (Vertex neighbor : graph.getAdjacencyList(vertex)) {
                    int newDist = longestPath.get(vertex) + 1;
                    if (newDist > longestPath.get(neighbor)) {
                        longestPath.put(neighbor, newDist);
                    }
                }
            }
        }

        for (Vertex vertex : graph.getVertices()) {
            if (longestPath.get(vertex) == Integer.MIN_VALUE) {
                longestPath.put(vertex, 0);
            }
        }

        return longestPath;
    }

    private static List<Vertex> topologicalSort(Graph graph) {
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        List<Vertex> order = new ArrayList<>();

        for (Vertex vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, stack, graph);
            }
        }

        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }

        return order;
    }

    private static void dfs(Vertex vertex, Set<Vertex> visited, Stack<Vertex> stack, Graph graph) {
        visited.add(vertex);
        for (Vertex neighbor : graph.getAdjacencyList(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, stack, graph);
            }
        }
        stack.push(vertex);
    }
}

