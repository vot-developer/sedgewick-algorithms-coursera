package org.sedgewick.algorithms.search;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BellmanFordShortPath {
    private final EdgeWeightedDigraph digraph;
    private final int s;
    private final double[] distTo;
    private final DirectedEdge[] edgeTo;

    public BellmanFordShortPath(EdgeWeightedDigraph digraph, int s) {
        this.digraph = digraph;
        this.s = s;
        this.distTo = new double[digraph.V()];
        this.edgeTo = new DirectedEdge[digraph.V()];

        for (int i = 0; i < distTo.length; i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0;

        for (int i = 0; i < digraph.V(); i++)
            for (DirectedEdge e : digraph.edges())
                relax(e);
    }

    Queue<DirectedEdge> find(int v){
        return buildPath(v);
    }

    private void relax(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    private Queue<DirectedEdge> buildPath(int v) {
        Deque<DirectedEdge> path = new ArrayDeque<>();
        if (distTo[v] == Double.POSITIVE_INFINITY)
            return null;
        do {
            path.addFirst(edgeTo[v]);
            v = edgeTo[v].from();
        } while (v != s);
        return path;
    }
}
