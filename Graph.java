import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjList; // Adjacency list

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>()); // Initialize empty lists for each vertex
        }
    }

    public void addEdge(int u, int v) {
        if (adjList.get(u).size() == 0) {
            adjList.set(u, new ArrayList<>()); // Initialize an empty list if none exists
        }
        adjList.get(u).add(v); // Add neighbor to the adjacency list of source
    }

    // Function to print all paths from u with length 5
    public void printAllPaths(int u, List<Integer> path) {
        if (path.size() == 6) {
            System.out.println(path);
            return;
        }
        for (int neighbor : adjList.get(u)) {
            path.add(neighbor);
            printAllPaths(neighbor, path);
            path.remove(path.size() - 1);
        }
    }

    // Function to print all paths of length 5
    public void printPaths(int source) {
        List<Integer> path = new ArrayList<>();
        path.add(source);
        printAllPaths(source, path);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        int source = 0;

        System.out.println("Paths from " + source + " with length 5:");
        g.printPaths(source);
    }
}


