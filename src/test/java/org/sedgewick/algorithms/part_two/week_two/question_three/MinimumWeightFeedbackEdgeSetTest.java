package org.sedgewick.algorithms.part_two.week_two.question_three;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumWeightFeedbackEdgeSetTest {
    /*
                1 --- 3
               /\ \  / \
              /  \ \/   \
             5 - 7-2    /
            /   /  \   /
            \  /\  /\ /
             4 - 0 - 6
         */
    private static EdgeWeightedGraph graph;

    @Test
    void compareSizes() {
        MinimumWeightFeedbackEdgeSet mwfes = new MinimumWeightFeedbackEdgeSet(graph);
        assertEquals(graph.E() - (graph.V() - 1), mwfes.getSet().size());
    }

    @BeforeAll
    static void setUp(){
        graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(1, 5, 0.32));
    }
}