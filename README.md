# Longest Path in a Directed Acyclic Graph (DAG)

This project implements a solution to find the longest path in a Directed Acyclic Graph (DAG) from a given start vertex. The graph is represented using custom `Vertex` and `Edge` classes, and the solution is optimized for scalability and efficiency.

## How It Works
- **Graph Representation:** The graph is implemented using an adjacency list, which is efficient in both space and time for sparse graphs.
- **Topological Sort:** The solution utilizes topological sorting to order vertices in a way that allows for dynamic programming to compute the longest path.
- **Longest Path Calculation:** The longest path from the start vertex is calculated using a dynamic programming approach, iterating over the vertices in topological order.

## Questions Answered
- **Scalability:** The solution works efficiently for large graphs, with a time complexity of `O(V + E)`.
- **Optimizations:** Suggestions for optimizations include early exit strategies in DFS and additional space optimizations.
- **Complexity:** The time complexity is `O(V + E)`, where `V` is the number of vertices and `E` is the number of edges.
- **Edge Cases:** The solution handles general cases, with considerations for disconnected graphs and vertices with no outgoing edges.

## How to Run
1. Compile the code using a Java compiler.
2. Run the `LongestPathInDAG` class to see the example execution with a predefined graph.

## Future Improvements
- Add support for detecting multiple longest paths.
- Handle disconnected components more gracefully.

## Test It With Some Data
![Screenshot (239)](https://github.com/user-attachments/assets/c398150e-b4e3-44af-8983-b32ba2f0e1fa)


## Author
- Mussie Teklehaimanot
