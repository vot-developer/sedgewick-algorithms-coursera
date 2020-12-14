package org.sedgewick.algorithms.part_two.week_two.question_six;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Stack;

public class ShortestSkippableEdge {
    public Iterable<DirectedEdge> find(EdgeWeightedDigraph g, int s, int t) {
        return null;
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
