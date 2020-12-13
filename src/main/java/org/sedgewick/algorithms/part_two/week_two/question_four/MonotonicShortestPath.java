package org.sedgewick.algorithms.part_two.week_two.question_four;


import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Not fixed problem with overwriting path (making shorter) that finally you will lose any path to targert.
 * Need store list edgesTo's to each vertex and choose second small if you couldn't do increase or decrease order only.
 */
public class MonotonicShortestPath {
    private final EdgeWeightedDigraph digraph;
    private final int s;
    private final double[] distTo;
    private final DirectedEdge[] edgeToASC;
    private final DirectedEdge[] edgeToDESC;
    private PriorityQueue<DirectedEdge> pq;

    public MonotonicShortestPath(EdgeWeightedDigraph digraph, int s) {
        this.digraph = digraph;
        this.s = s;
        this.distTo = new double[digraph.V()];
        this.edgeToASC = new DirectedEdge[digraph.V()];
        this.edgeToDESC = new DirectedEdge[digraph.V()];

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

    public Queue<edu.princeton.cs.algs4.DirectedEdge> findAsc(int v) {
        return buildPath(v, edgeToASC);
    }

    public Queue<edu.princeton.cs.algs4.DirectedEdge> findDesc(int v) {
        return buildPath(v, edgeToDESC);
    }

    private void relax(DirectedEdge e, DirectedEdge[] edgeTo) {
        int v = e.from();
        int w = e.to();

        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    private Queue<edu.princeton.cs.algs4.DirectedEdge> buildPath(int v, DirectedEdge[] edgeTo) {
        Deque<edu.princeton.cs.algs4.DirectedEdge> path = new ArrayDeque<>();
        do {
            path.addFirst(edgeTo[v].toAlgsEdge());
            v = edgeTo[v].from();
        } while (v != s);
        return path;
    }
}
