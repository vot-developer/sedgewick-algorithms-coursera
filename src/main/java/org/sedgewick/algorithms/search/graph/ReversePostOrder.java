package org.sedgewick.algorithms.search.graph;

import edu.princeton.cs.algs4.Digraph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class ReversePostOrder {
    private final Digraph digraph;
    private final boolean[] marked;
    private final Deque<Integer> stack;


    public ReversePostOrder(Digraph digraph) {
        this.digraph = digraph;
        marked = new boolean[digraph.V()];
        stack = new ArrayDeque<>();
        for (int i = 0; i < digraph.V(); i++)
            if (!marked[i])
                dfs(i);
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int i : digraph.adj(v)) {
            if (!marked[i])
                dfs(i);
        }
        stack.addFirst(v);
    }

    public Collection<Integer> topologicalOrder() {
        return stack;
    }
}
