package org.sedgewick.algorithms.part_two.week_three.question_three;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import org.sedgewick.algorithms.search.FordFulkersonMaximumFlowSearch;

import java.util.ArrayList;
import java.util.List;

public class MaximumWeightClosureProblem {

    public List<Integer> findMaximumClosedSubset(Digraph inDigraph, double[] weights){
        FlowNetwork digraph = new FlowNetwork(inDigraph.V() + 2);
        for (int v = 0; v < inDigraph.V(); v++)
            for (int w : inDigraph.adj(v))
                digraph.addEdge(new FlowEdge(v, w, Double.POSITIVE_INFINITY));

        int s = inDigraph.V();
        int t = s + 1;

        for (int v = 0; v < weights.length; v++){
            double weight = weights[v];
            if (weight >= 0)
                digraph.addEdge(new FlowEdge(s, v, weight));
            else
                digraph.addEdge(new FlowEdge(v, t, -weight));
        }

        FordFulkersonMaximumFlowSearch ffSearch = new FordFulkersonMaximumFlowSearch(digraph, s, t);
        List<Integer> result = new ArrayList<>();
        for (int v = 0; v < inDigraph.V(); v++)
            if (ffSearch.inCut(v))
                result.add(v);

        return result;
    }
}
