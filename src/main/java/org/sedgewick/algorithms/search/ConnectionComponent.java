package org.sedgewick.algorithms.search;


import edu.princeton.cs.algs4.Graph;

public class ConnectionComponent {
    private final Graph graph;
    private final Integer[] id;
    private final boolean[] marked;
    private int idCount;

    public ConnectionComponent(Graph graph) {
        this.graph = graph;
        this.id = new Integer[graph.V()];
        this.marked = new boolean[graph.V()];

        idCount = 0;
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                dfs(i);
                idCount++;
            }
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        this.id[v] = idCount;

        for (int i : graph.adj(v)) {
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
