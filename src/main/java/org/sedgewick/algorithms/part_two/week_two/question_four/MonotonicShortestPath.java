package org.sedgewick.algorithms.part_two.week_two.question_four;


import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * time - O(E * Log E)
 * space - O(V * E)
 */
public class MonotonicShortestPath {
    private final EdgeWeightedDigraph digraph;
    private final int s;
    private final double[] distTo;
    private final List<edu.princeton.cs.algs4.DirectedEdge>[] edgeToASC;
    private final List<edu.princeton.cs.algs4.DirectedEdge>[] edgeToDESC;
    private PriorityQueue<DirectedEdge> pq;

    public MonotonicShortestPath(EdgeWeightedDigraph digraph, int s) {
        this.digraph = digraph;
        this.s = s;
        this.distTo = new double[digraph.V()];
        this.edgeToASC = new List[digraph.V()];
        this.edgeToDESC = new List[digraph.V()];

        //ASC
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < digraph.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0;

        for (edu.princeton.cs.algs4.DirectedEdge edge : digraph.edges())
            pq.add(new DirectedEdge(edge));
        while (!pq.isEmpty()) {
            DirectedEdge e = pq.poll();
            relax(e, edgeToASC);
        }

        //DESC
        this.pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < digraph.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0;

        for (edu.princeton.cs.algs4.DirectedEdge edge : digraph.edges())
            pq.add(new DirectedEdge(edge));
        while (!pq.isEmpty()) {
            DirectedEdge e = pq.poll();
            relax(e, edgeToDESC);
        }
    }

    public List<edu.princeton.cs.algs4.DirectedEdge> findAsc(int v) {
        return buildPath(v, edgeToASC);
    }

    public List<edu.princeton.cs.algs4.DirectedEdge> findDesc(int v) {
        return buildPath(v, edgeToDESC);
    }

    private void relax(DirectedEdge e, List<edu.princeton.cs.algs4.DirectedEdge>[] edgeTo) {
        int v = e.from();
        int w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            List<edu.princeton.cs.algs4.DirectedEdge> edgeToW = new ArrayList<>(edgeTo[v] != null ? edgeTo[v] : new ArrayList<>());
            edgeToW.add(e.toAlgsEdge());
            edgeTo[w] = edgeToW;
        }
    }

    private List<edu.princeton.cs.algs4.DirectedEdge> buildPath(int v, List<edu.princeton.cs.algs4.DirectedEdge>[] edgeTo) {
        return edgeTo[v];
    }
}
