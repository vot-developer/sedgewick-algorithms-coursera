package org.sedgewick.algorithms.part_two.week_two.question_three;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import org.sedgewick.algorithms.structures.UnionFind;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MinimumWeightFeedbackEdgeSet {
    private final EdgeWeightedGraph graph;
    private final Set<Edge> set;
    private final UnionFind uf;
    private final TreeSet<Edge> pq;

    public MinimumWeightFeedbackEdgeSet(EdgeWeightedGraph graph) {
        this.graph = graph;
        this.set = new HashSet<>();
        this.uf = new UnionFind(graph.V());
        this.pq = new TreeSet<>(Collections.reverseOrder()); //we could find set through MAXIMUM spanning tree algorithm.
        calculate();
    }

    private void calculate(){
        for (Edge e : graph.edges())
            pq.add(e);

        while (!pq.isEmpty()){
            Edge e = pq.pollFirst();
            int v = e.either();
            int w = e.other(v);
            if (!uf.isConnected(v, w)){
                uf.union(v, w); //there would be added edge to MST
            } else {
                set.add(e); //we save edge which would be skipped (for prevent cycle) in MST
            }
        }
    }

    public Set<Edge> getSet() {
        return new HashSet<>(set);
    }
}
