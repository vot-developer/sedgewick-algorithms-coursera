package org.sedgewick.algorithms.part_two.week_two.question_two;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

public class EdgeIsInMST {
    public boolean isInMST(Edge e, EdgeWeightedGraph g) {
        int v = e.either();
        int w = e.other(v);

        return isMin(e, v, g) || isMin(e, w, g);
    }

    private boolean isMin(Edge e, int v, EdgeWeightedGraph g) {
        for (Edge i : g.adj(v))
            if (i.weight() < e.weight()) return false;

        return true;
    }


}
