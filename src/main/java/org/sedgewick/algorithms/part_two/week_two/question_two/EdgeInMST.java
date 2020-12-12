package org.sedgewick.algorithms.part_two.week_two.question_two;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

import java.util.ArrayDeque;
import java.util.Deque;

public class EdgeInMST {
    public boolean isIn(Edge e, EdgeWeightedGraph g) {
        int v = e.either();
        if (isConnectedByLessWeight(v, e.other(v), Double.POSITIVE_INFINITY, g)) //generally connected
            return !isConnectedByLessWeight(v, e.other(v), e.weight(), g); //but with edges less then 'e' - not

        return false;
    }

    public boolean isConnectedByLessWeight(int v, int w, double weight, EdgeWeightedGraph g){
        boolean[] marked = new boolean[g.V()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(v);
        marked[v] = true;
        while (!stack.isEmpty()){
            int vertex = stack.removeFirst();
            if (vertex == w) return true;
            for (Edge e : g.adj(vertex)){
                if (e.weight() >= weight) continue;
                int i = e.other(vertex);
                if (!marked[i]) {
                    stack.addFirst(i);
                    marked[i] = true;
                }
            }
        }
        return false;
    }
}
