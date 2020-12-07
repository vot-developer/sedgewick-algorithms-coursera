package org.sedgewick.algorithms.search;

import edu.princeton.cs.algs4.Digraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DigraphConnectionComponentTest {
    private Digraph digraph;

    @BeforeEach
    void setUp() {
        digraph = new Digraph(7);
        digraph.addEdge(0, 5);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 1);
        digraph.addEdge(3, 6);
        digraph.addEdge(3, 5);
        digraph.addEdge(3, 4);
        digraph.addEdge(5, 2);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(1, 4);
    }

    @Test
    void topologicalOrder() {
        DigraphConnectionComponent dcc = new DigraphConnectionComponent(digraph);
        assertTrue(dcc.isConnected(3, 5));
    }
}