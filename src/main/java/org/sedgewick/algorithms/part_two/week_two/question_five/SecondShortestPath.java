package org.sedgewick.algorithms.part_two.week_two.question_five;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.Path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SecondShortestPath {

    /*
    time - O(E * Log V)
    space - O(V)
     */
    public Path find(EdgeWeightedDigraph g, int s, int t) {
        DijkstraSP directSP = new DijkstraSP(g, s);
        EdgeWeightedDigraph reverseG = reverse(g);
        DijkstraSP reverseSP = new DijkstraSP(reverseG, t);

        //time - O(V * Log V)
        TreeSet<Path> pq = new TreeSet<>();
        double weight;
        for (int v = 0; v < g.V(); v++) {
            weight = directSP.distTo(v) + reverseSP.distTo(v);
            Set<org.sedgewick.algorithms.structures.DirectedEdge> deque = new LinkedHashSet<>();
            Deque<org.sedgewick.algorithms.structures.DirectedEdge> stack = new ArrayDeque<>();
            for (DirectedEdge e : directSP.pathTo(v))
                deque.add(new org.sedgewick.algorithms.structures.DirectedEdge(e));
            for (DirectedEdge e : reverseSP.pathTo(v))
                stack.addFirst(new org.sedgewick.algorithms.structures.DirectedEdge(e.to(), e.from(), e.weight()));
            deque.addAll(stack);
            pq.add(new Path(weight, deque));
        }

        pq.pollFirst();//shortest path
        return pq.pollFirst();//second shortest path
    }

    private EdgeWeightedDigraph reverse(EdgeWeightedDigraph g) {
        EdgeWeightedDigraph reverse = new EdgeWeightedDigraph(g.V());
        for (int v = 0; v < g.V(); v++) {
            for (DirectedEdge e : g.adj(v)) {
                reverse.addEdge(new DirectedEdge(e.to(), e.from(), e.weight()));
            }
        }
        return reverse;
    }
}
