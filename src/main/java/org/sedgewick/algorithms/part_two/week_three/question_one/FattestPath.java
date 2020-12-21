package org.sedgewick.algorithms.part_two.week_three.question_one;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class FattestPath {
    private final EdgeWeightedDigraph digraph;
    private final int s;
    private final int t;
    private final DirectedEdge[] edgeTo;
    private final boolean[] marked;
    private double[] bottleneckTo;

    public FattestPath(EdgeWeightedDigraph digraph, int s, int t) {
        this.digraph = digraph;
        this.s = s;
        this.t = t;
        this.edgeTo = new DirectedEdge[digraph.V()];
        this.marked = new boolean[digraph.V()];
        this.bottleneckTo = new double[digraph.V()];

        for (int i = 0; i < bottleneckTo.length; i++)
            bottleneckTo[i] = Double.POSITIVE_INFINITY;

        PriorityQueue<DirectedEdge> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new DirectedEdge(0, 0, Double.POSITIVE_INFINITY));
        while (!pq.isEmpty()) {
            DirectedEdge vEdge = pq.poll();
            int v = vEdge.to();
            if (!marked[v]) {
                marked[v] = true;
                edgeTo[v] = vEdge;
                bottleneckTo[v] = Math.min(bottleneckTo[vEdge.from()], vEdge.weight());
                if (v == t) break;
                for (edu.princeton.cs.algs4.DirectedEdge e : digraph.adj(v))
                    pq.add(new DirectedEdge(e));
            }
        }
    }

    public Iterable<Integer> path(){
        Deque<Integer> path = new ArrayDeque<>();
        for (int i = t; i != s; i = edgeTo[i].from())
            path.addFirst(i);
        return path;
    }

    public double bottleneck(){
        return bottleneckTo[t];
    }
}
