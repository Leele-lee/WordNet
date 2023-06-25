package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int V;  // represent the number of vertexes
    private int E; // represent the number of edges
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E = E + 1;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public List<Integer> getAdj(int v) {
        return adj[v];
    }
}
