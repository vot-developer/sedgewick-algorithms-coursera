package org.sedgewick.algorithms.part_two.week_two.question_five;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/*
    time - O(k^2 * E * log E), if k = C -> O(E * log E)
    space - O(k*V*E), if k = C -> space -> O(V*E)
 */
public class KShortPaths {
    private final EdgeWeightedDigraph digraph;
    private final TreeSet<Path>[] distTo;
    private final PriorityQueue<DirectedEdge> pq;
    private final int s;
    private final int k;

    public KShortPaths(EdgeWeightedDigraph digraph, int s, int k) {
        this.digraph = digraph;
        this.distTo = new TreeSet[digraph.V()];
        this.pq = new PriorityQueue();
        this.s = s;
        this.k = k;

        for (int i = 0; i < distTo.length; i++)
            distTo[i] = new TreeSet();

        pq.add(new DirectedEdge(0, 0, 0.0));        //for run while process
        distTo[0].add(new Path(0.0, new LinkedList<>())); //for fork all paths from that
        while (!pq.isEmpty()) {
            DirectedEdge edge = pq.poll();
            for (edu.princeton.cs.algs4.DirectedEdge e : digraph.adj(edge.to()))
                relax(new DirectedEdge(e));
        }
    }

    public Path find(int v, int k) {
        if (k > this.k) return null;

        Iterator<Path> it = distTo[v].iterator();
        for (int i = 0; i < k - 1 && it.hasNext(); i++)
            it.next();

        if (it.hasNext())
            return it.next();
        return null;
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        List<Path> listToAdd = new ArrayList<>(distTo[v].size());
        for (Path pathV : distTo[v]){
            if (distTo[w].size() < k) {
                pathV = pathV.fork();
                pathV.addEdge(e);
                listToAdd.add(pathV);
            } else {
                for (Path pathW : distTo[w]){
                    if (pathW.weight > pathV.weight + e.weight()){
                        pathV = pathV.fork();
                        pathV.addEdge(e);
                        listToAdd.add(pathV);
                    }
                }
            }
        }

        for (Path path : listToAdd)
            distTo[w].add(path);
        if (distTo[w].size() > k){
            for (int i = 0; i < distTo[w].size() - k; i++)
                distTo[w].remove(distTo[w].last());
        }

        if (listToAdd.size() > 0)
            pq.add(e);
    }
}
