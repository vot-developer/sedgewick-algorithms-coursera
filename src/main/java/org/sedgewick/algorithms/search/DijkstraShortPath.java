package org.sedgewick.algorithms.search;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.TreeSet;

/*
 time - O(E * Log(V))
 space - O(V)
 */
public class DijkstraShortPath {
    private final EdgeWeightedDigraph digraph;
    private final edu.princeton.cs.algs4.DirectedEdge[] edgeTo;
    private final double[] distTo;
    private final TreeSet<DirectedEdge> pq;
    private final DirectedEdge[] edgeToVertex;
    private final int s;

    public DijkstraShortPath(EdgeWeightedDigraph digraph, int s) {
        this.digraph = digraph;
        this.edgeTo = new edu.princeton.cs.algs4.DirectedEdge[digraph.V()];
        this.distTo = new double[digraph.V()];
        this.pq = new TreeSet();
        this.edgeToVertex = new DirectedEdge[digraph.V()];
        this.s = s;

        for (int i = 0; i < distTo.length; i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0;

        pq.add(new DirectedEdge(0, 0, 0.0));
        while (!pq.isEmpty()) {
            DirectedEdge visitedEdge = pq.pollFirst();
            edgeToVertex[visitedEdge.to()] = null;
            visit(visitedEdge.to());
        }
    }

    public Queue<edu.princeton.cs.algs4.DirectedEdge> find(int v) {
        return buildPath(v);
    }

    private void visit(int v) {
        for (edu.princeton.cs.algs4.DirectedEdge de : digraph.adj(v)) {
            DirectedEdge e = new DirectedEdge(de);
            int i = e.to();
            if (distTo[i] > distTo[v] + e.weight()) {
                distTo[i] = distTo[v] + e.weight();
                edgeTo[i] = de;
                if (edgeToVertex[i] != null) {
                    DirectedEdge oldEdge = edgeToVertex[i];
                    pq.remove(oldEdge);
                }
                edgeToVertex[i] = e;
                pq.add(e);
            }
        }
    }

    private Queue<edu.princeton.cs.algs4.DirectedEdge> buildPath(int v) {
        Deque<edu.princeton.cs.algs4.DirectedEdge> path = new ArrayDeque<>();
        if (distTo[v] == Double.POSITIVE_INFINITY)
            return null;
        do {
            path.addFirst(edgeTo[v]);
            v = edgeTo[v].from();
        } while (v != s);
        return path;
    }
}
