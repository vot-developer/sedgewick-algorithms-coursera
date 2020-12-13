package org.sedgewick.algorithms.search;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 time - O(E * Log(V))
 space - O(V)
 */
public class DijkstraShortPath {
    private final EdgeWeightedDigraph digraph;
    private final edu.princeton.cs.algs4.DirectedEdge[] edgeTo;
    private final double[] distTo;
    private final PriorityQueue<DirectedEdge> pq;
    private final DirectedEdge[] edgeToVertex;
    private final int s;

    public DijkstraShortPath(EdgeWeightedDigraph digraph, int s) {
        this.digraph = digraph;
        this.edgeTo = new edu.princeton.cs.algs4.DirectedEdge[digraph.V()];
        this.distTo = new double[digraph.V()];
        this.pq = new PriorityQueue();
        this.edgeToVertex = new DirectedEdge[digraph.V()];
        this.s = s;

        for (int i = 0; i < distTo.length; i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0;

        pq.add(new DirectedEdge(0, 0, 0.0));
        while (!pq.isEmpty()) {
            DirectedEdge edge = pq.poll();
            edgeToVertex[edge.to()] = null;
            for (edu.princeton.cs.algs4.DirectedEdge e : digraph.adj(edge.to())) {
                relax(new DirectedEdge(e));
            }
        }
    }

    public Queue<edu.princeton.cs.algs4.DirectedEdge> find(int v) {
        return buildPath(v);
    }

    private void relax(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()){
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e.toAlgsEdge();
            //update queue
            if (edgeToVertex[w] != null) {
                DirectedEdge oldEdge = edgeToVertex[w];
                pq.remove(oldEdge);
            }
            edgeToVertex[w] = e;
            pq.add(e);
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
