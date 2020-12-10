package org.sedgewick.algorithms.part_two.week_two.question_one;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BottleneckMinimumSpanningTree {
    private final EdgeWeightedGraph g;
    private final Queue<Edge> bmst;
    private final Set<Integer> visited;
    private double maxWeight = 0;
    private double weight = 0;

    public BottleneckMinimumSpanningTree(EdgeWeightedGraph g) {
        this.g = g;
        this.bmst = new ArrayDeque<>();
        this.visited = new HashSet<>();
        computeTree();
    }

    public Iterable<Edge> edges() {
        return bmst;
    }

    public double maxWeight() {
        return maxWeight;
    }

    public double weight() {
        return weight;
    }

    private void computeTree() {
        dfsByWeight(0);
    }

    private void dfsByWeight(int v) {
        if (visited.contains(v)) return;

        visited.add(v);
        boolean isAdded = false;
        for (Edge e : g.adj(v)) {
            if (!visited.contains(e.other(v))) {
                if (e.weight() < maxWeight) {
                    isAdded = true;
                    storeEdge(e, e.other(v));
                }
            }
        }

        if (!isAdded){
            Edge minEdge = findUnvisitedMinimum();
            if (minEdge != null) {
                int minV = visited.contains(minEdge.either()) ? minEdge.either() : minEdge.other(minEdge.either()); //visited
                int minW = minEdge.other(minV); //unvisited
                storeEdge(minEdge, minW);
            }
        }
    }

    private void storeEdge(Edge edge, int v) {
        bmst.add(edge);
        weight += edge.weight();
        if (maxWeight < edge.weight())
            maxWeight = edge.weight();
        dfsByWeight(v);
    }

    private Edge findUnvisitedMinimum() {
        double min = Double.MAX_VALUE;

        Edge minEdge = null;
        for (int v : visited) {
            for (Edge e : g.adj(v)) {
                if (visited.contains(e.other(v))) continue;

                if (e.weight() < min) {
                    minEdge = e;
                    min = e.weight();
                }
            }
        }
        return minEdge;
    }
}
