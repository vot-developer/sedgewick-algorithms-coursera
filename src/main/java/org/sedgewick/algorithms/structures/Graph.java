package org.sedgewick.algorithms.structures;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;
    private final List<Integer>[] edges;

    public Graph(int V) {
        this.V = V;
        this.edges = new List[this.V];
        for (int i = 0; i < this.V; i++)
            edges[i] = new LinkedList<>();
    }

    public void addEdge(int a, int b){
        edges[a].add(b);
        edges[b].add(a);
    }

    public List<Integer> adj(int v){
        return edges[v];
    }

    public int V() {
        return V;
    }
}
