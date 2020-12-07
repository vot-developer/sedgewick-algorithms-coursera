package org.sedgewick.algorithms.part_two.week_one.question_six;

import edu.princeton.cs.algs4.Digraph;
import org.sedgewick.algorithms.search.ReversePostOrder;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class ReachableVertex {

    public int find(Digraph digraph) {
        Digraph reverse = digraph.reverse();
        Collection<Integer> topologicalOrder = new ReversePostOrder(reverse).topologicalOrder();
        if (digraph.V() > 2) {
            int candidate = topologicalOrder.iterator().next();
            int count = dfsCount(candidate, reverse);
            if (count == reverse.V())
                return candidate;
        } else {
            return 0;
        }
        return -1;
    }

    private int dfsCount(int v, Digraph digraph) {
        int count = 0;
        boolean[] marked = new boolean[digraph.V()];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(v);

        while (!deque.isEmpty()) {
            int j = deque.removeFirst();
            marked[j] = true;
            count++;
            for (int i : digraph.adj(j))
                if (!marked[i])
                    deque.addFirst(i);
        }
        return count;
    }
}
