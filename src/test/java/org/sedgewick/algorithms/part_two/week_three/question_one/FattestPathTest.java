package org.sedgewick.algorithms.part_two.week_three.question_one;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FattestPathTest {
    private static EdgeWeightedDigraph digraph;

    @Test
    void bottleneck() {
        FattestPath fattestPath = new FattestPath(digraph, 0, 5);
        assertEquals(9.0, fattestPath.bottleneck());
        Iterator<Integer> it = fattestPath.path().iterator();
        assertEquals(1, it.next());
        assertEquals(3, it.next());
        assertEquals(5, it.next());
        assertFalse(it.hasNext());
    }

    @BeforeAll
    static void setUp() {
        digraph = new EdgeWeightedDigraph(6);
        digraph.addEdge(new DirectedEdge(0, 1, 10));
        digraph.addEdge(new DirectedEdge(0, 2, 5));
        digraph.addEdge(new DirectedEdge(1, 3, 9));
        digraph.addEdge(new DirectedEdge(1, 4, 4));
        digraph.addEdge(new DirectedEdge(2, 1, 4));
        digraph.addEdge(new DirectedEdge(2, 4, 8));
        digraph.addEdge(new DirectedEdge(3, 5, 10));
        digraph.addEdge(new DirectedEdge(3, 4, 15));
        digraph.addEdge(new DirectedEdge(4, 5, 10));
    }
}