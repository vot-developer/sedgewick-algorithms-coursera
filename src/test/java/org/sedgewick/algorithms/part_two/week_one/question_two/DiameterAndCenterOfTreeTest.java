package org.sedgewick.algorithms.part_two.week_one.question_two;

import edu.princeton.cs.algs4.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterAndCenterOfTreeTest {
    private static Graph graph;
    /*
    1 - 0 - 6 - 4 - 5 - 3
       /             \
      2              7 - 8
     */
    @BeforeAll
    static void setUp(){
        graph = new Graph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(6, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(5, 7);
        graph.addEdge(7, 8);
    }

    @Test
    void diameter() {
        DiameterAndCenterOfTree dc = new DiameterAndCenterOfTree(graph);
        assertEquals(6, dc.diameter());
    }

    @Test
    void center() {
        DiameterAndCenterOfTree dc = new DiameterAndCenterOfTree(graph);
        assertEquals(4, dc.center());
    }
}