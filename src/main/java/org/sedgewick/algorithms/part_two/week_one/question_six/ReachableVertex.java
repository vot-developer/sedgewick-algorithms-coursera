package org.sedgewick.algorithms.part_two.week_one.question_six;

import edu.princeton.cs.algs4.Digraph;
import org.sedgewick.algorithms.search.graph.ReversePostOrder;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class ReachableVertex {

    public int findDAG(Digraph digraph) {
        if (digraph == null || digraph.V() == 0) return -1;
        if (digraph.V() == 1) return 0;

        Digraph reverse = digraph.reverse();
        Collection<Integer> topologicalOrder = new ReversePostOrder(reverse).topologicalOrder();
        int candidate = topologicalOrder.iterator().next();
        int count = dfsCount(candidate, reverse);
        if (count == reverse.V())
            return candidate;

        return -1;
    }

    public int find(Digraph digraph) {
        if (digraph == null || digraph.V() == 0) return -1;
        if (digraph.V() == 1) return 0;

        Collection<Integer> topologicalOrder = new ReversePostOrder(digraph.reverse()).topologicalOrder();
        int[] id = new int[digraph.V()];
        boolean[] marked = new boolean[digraph.V()];
        int count = 0;
        for (int i : topologicalOrder) {
            if (!marked[i])
                dfsStrongConnectedComponents(i, digraph, id, marked, count++);
        }
        //shrink strong connection groups in points
        Digraph dag = new Digraph(count);
        for (int i = 0; i < digraph.V(); i++)
            for (int v : digraph.adj(i))
                if (id[i] != id[v])
                    dag.addEdge(id[i], id[v]);

        int dagResult = findDAG(dag);
        if (dagResult == -1) return -1;

        //convert from DAG to passed digraph
        for (int i = 0; i < digraph.V(); i++)
            if (id[i] == dagResult)
                return i;

        return -1;
    }

    private void dfsStrongConnectedComponents(int v, Digraph digraph, int[] id, boolean[] marked, int count) {
        marked[v] = true;
        id[v] = count;
        for (int i : digraph.adj(v)) {
            if (!marked[i])
                dfsStrongConnectedComponents(i, digraph, id, marked, count);
        }
    }

    private int dfsCount(int v, Digraph digraph) {
        int count = 1;
        boolean[] marked = new boolean[digraph.V()];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(v);
        marked[v] = true;

        while (!deque.isEmpty()) {
            int j = deque.removeFirst();
            for (int i : digraph.adj(j))
                if (!marked[i]) {
                    deque.addFirst(i);
                    marked[i] = true;
                    count++;
                }
        }
        return count;
    }
}
