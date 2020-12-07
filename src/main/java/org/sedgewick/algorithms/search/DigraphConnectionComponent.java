package org.sedgewick.algorithms.search;


import edu.princeton.cs.algs4.DepthFirstOrder;
import edu.princeton.cs.algs4.Digraph;

public class DigraphConnectionComponent {
    private final Digraph digraph;
    private final Integer[] id;
    private final boolean[] marked;
    private int idCount;

    public DigraphConnectionComponent(Digraph digraph) {
        this.digraph = digraph;
        this.id = new Integer[digraph.V()];
        this.marked = new boolean[digraph.V()];

        idCount = 0;
        for (int i : new ReversePostOrder(digraph.reverse()).topologicalOrder()) {
            if (!marked[i]) {
                dfs(i);
                idCount++;
            }
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        this.id[v] = idCount;

        for (int i : digraph.adj(v)) {
            if (!marked[i])
                dfs(i);
        }
    }

    public boolean isConnected(int a, int b) {
        return id[a] == id[b];
    }

    public int count() {
        return idCount;
    }

    public int id(int v) {
        return id[v];
    }
}
