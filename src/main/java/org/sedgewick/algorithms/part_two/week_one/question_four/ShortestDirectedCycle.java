package org.sedgewick.algorithms.part_two.week_one.question_four;

import edu.princeton.cs.algs4.Digraph;

import java.util.*;

public class ShortestDirectedCycle {

    private Set<Integer> stack = new LinkedHashSet<>();
    private Digraph digraph;
    private boolean[] marked;
    private int[] pathTo;
    Deque<Integer> cycle;

    /*
    time - O(V * (V + E))
    space - O(V + E)
     */
    Collection<Integer> dfs(Digraph digraph) {
        this.digraph = digraph;
        stack.clear();
        marked = new boolean[digraph.V()];
        pathTo = new int[digraph.V()];
        cycle = null;

        for (int i = 0; i < digraph.V(); i++)
            if (!marked[i])
                dfs(i);

        return cycle;
    }

    private void dfs(int v) {
        marked[v] = true;
        stack.add(v);
        for (int i : digraph.adj(v)) {
            if (!marked[i]) {
                pathTo[i] = v;
                dfs(i);
            } else if (stack.contains(i)) {
                cutCycle(i);
            }
        }
        stack.remove(v);
    }

    private void cutCycle(int v) {
        Deque<Integer> cycle = new ArrayDeque<>();
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            if (it.next() == v) {
                cycle.addLast(v);
                while (it.hasNext())
                    cycle.addLast(it.next());
            }
        }
        if (this.cycle == null || this.cycle.size() > cycle.size())
            this.cycle = cycle;
    }

}
