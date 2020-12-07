package org.sedgewick.algorithms.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.algs4.Graph;

import static org.junit.jupiter.api.Assertions.*;

class GraphConnectionComponentTest {
    private static Graph graph;
    /*
    6 - 0 - 1 - 4 - 5 - 3
       /
      2

      9 - 10    7-8
     / \
    11-12
     */
    @BeforeAll
    static void setUp(){
        graph = new Graph(13);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
    }

    @Test
    void isConnected() {
        GraphConnectionComponent cc = new GraphConnectionComponent(graph);
        assertTrue(cc.isConnected(3, 6));
        assertTrue(cc.isConnected(10, 11));
        assertTrue(cc.isConnected(7, 8));
        assertFalse(cc.isConnected(0, 7));
        assertFalse(cc.isConnected(9, 3));
    }

    @Test
    void count() {
        GraphConnectionComponent cc = new GraphConnectionComponent(graph);
        assertEquals(3, cc.count());
    }

    @Test
    void id() {
        GraphConnectionComponent cc = new GraphConnectionComponent(graph);
        assertEquals(1, cc.id(7));
    }
}