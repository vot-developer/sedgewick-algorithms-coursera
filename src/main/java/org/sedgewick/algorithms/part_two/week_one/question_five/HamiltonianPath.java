package org.sedgewick.algorithms.part_two.week_one.question_five;

import edu.princeton.cs.algs4.Digraph;
import org.sedgewick.algorithms.search.graph.ReversePostOrder;

import java.util.Collection;

/*
    time - O(V + E)
    space - O(V)
 */
public class HamiltonianPath {
    private final Digraph digraph;
    private final boolean[] marked;
    private final Collection<Integer> topologicalOrder;

    public HamiltonianPath(Digraph digraph) {
        this.digraph = digraph;
        this.marked = new boolean[digraph.V()];
        this.topologicalOrder = new ReversePostOrder(digraph).topologicalOrder();

        if (digraph.V() > 2) {
            dfs(topologicalOrder.iterator().next());
        } else {
            marked[0] = true;
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int i : digraph.adj(v)) {
            if (!marked[i])
                dfs(i);
        }
    }

    public boolean isExistHamiltonianPath() {
        for (int i = 0; i < marked.length; i++)
            if (!marked[i]) return false;

        return true;
    }

    public Collection<Integer> getPath() {
        if (isExistHamiltonianPath())
            return topologicalOrder;
        return null;
    }
}
