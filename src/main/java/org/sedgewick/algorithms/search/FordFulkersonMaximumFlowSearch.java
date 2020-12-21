package org.sedgewick.algorithms.search;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class FordFulkersonMaximumFlowSearch {
    private final FlowNetwork flowNetwork;
    private final int s;
    private final int t;
    private boolean marked[];
    private FlowEdge edgeTo[];
    private double value;

    public FordFulkersonMaximumFlowSearch(FlowNetwork flowNetwork, int s, int t) {
        this.flowNetwork = flowNetwork;
        this.s = s;
        this.t = t;

        calculateFlow();
    }

    public double value(){
        return value;
    }

    private void calculateFlow() {
        while(hasAugmentingPath()){
            double bottleneck = Double.POSITIVE_INFINITY;
            for (int i = t; i != s; i = edgeTo[i].other(i))
                bottleneck = Math.min(bottleneck, edgeTo[i].residualCapacityTo(i));

            for (int i = t; i != s; i = edgeTo[i].other(i))
                edgeTo[i].addResidualFlowTo(i, bottleneck);

            value += bottleneck;
        }
    }

    private boolean hasAugmentingPath(){
        marked = new boolean[flowNetwork.V()];
        edgeTo = new FlowEdge[flowNetwork.V()];

        Deque<Integer> queue = new ArrayDeque<>(flowNetwork.V());
        queue.addLast(s);
        marked[s] = true;
        while (!queue.isEmpty()){
            int v = queue.removeFirst();
            for (FlowEdge e : flowNetwork.adj(v)){
                int w = e.other(v);
                if (!marked[w] && e.residualCapacityTo(w) > 0){
                    marked[w] = true;
                    edgeTo[w] = e;
                    queue.addLast(w);
                }
            }
        }
        return marked[t];
    }
}
