package org.sedgewick.algorithms.part_two.week_one.question_two;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;

import java.util.Iterator;

public class DiameterAndCenterOfTree {
    private final Graph graph;
    private int diameter;
    private int center;

    public DiameterAndCenterOfTree(Graph graph) {
        this.graph = graph;
        calculate();
    }

    public int diameter() {
        return diameter;
    }

    public int center() {
        return center;
    }

    private void calculate() {
        int start = findMaxLongestVertex(0);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, start);
        int distMax = 0;
        int end = 0;
        for (int v = 0; v < graph.V(); v++) {
            if (v == start) continue;
            if (bfs.distTo(v) > distMax) {
                distMax = bfs.distTo(v);
                end = v;
            }
        }

        diameter = distMax;
        int centerStep = distMax/2;
        Iterator<Integer> it = bfs.pathTo(end).iterator();
        for (int i = 0; i < centerStep; i++)
            it.next();
        center = it.next();
    }


    private int findMaxLongestVertex(int pivot) {
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, pivot);
        int distMax = 0, vertexMax = 0;
        for (int v = 0; v < graph.V(); v++) {
            if (v == pivot) continue;
            if (bfs.distTo(v) > distMax) {
                vertexMax = v;
                distMax = bfs.distTo(v);
            }
        }
        return vertexMax;
    }
}
