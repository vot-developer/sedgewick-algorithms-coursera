package org.sedgewick.algorithms.part_two.week_two.question_six;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.Path;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ShortestSkippableEdge {

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
        for (int v = 0; v < g.V(); v++)
            for (DirectedEdge e : g.adj(v)) {
                weight = directSP.distTo(e.from()) + reverseSP.distTo(e.to());//weight of shortest path through e.from() and e.to() without e.
                Set<org.sedgewick.algorithms.structures.DirectedEdge> deque = new LinkedHashSet<>();
                Deque<org.sedgewick.algorithms.structures.DirectedEdge> stack = new ArrayDeque<>();
                for (DirectedEdge ep : directSP.pathTo(e.from()))
                    deque.add(new org.sedgewick.algorithms.structures.DirectedEdge(ep));
                for (DirectedEdge ep : reverseSP.pathTo(e.to()))
                    stack.addFirst(new org.sedgewick.algorithms.structures.DirectedEdge(ep.to(), ep.from(), ep.weight()));
                deque.addAll(stack);
                pq.add(new Path(weight, deque));
            }

        return pq.pollFirst();//shortest path
    }

    public EdgeWeightedDigraph reverse(EdgeWeightedDigraph g) {
        EdgeWeightedDigraph reverse = new EdgeWeightedDigraph(g.V());
        for (int v = 0; v < g.V(); v++) {
            for (DirectedEdge e : g.adj(v)) {
                reverse.addEdge(new DirectedEdge(e.to(), e.from(), e.weight()));
            }
        }
        return reverse;
    }
}
