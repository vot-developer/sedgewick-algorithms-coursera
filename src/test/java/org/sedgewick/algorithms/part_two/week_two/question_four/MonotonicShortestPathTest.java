package org.sedgewick.algorithms.part_two.week_two.question_four;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class MonotonicShortestPathTest {
    private static EdgeWeightedDigraph digraph;

    @Test
    void increasingPath() {
        MonotonicShortestPath msp = new MonotonicShortestPath(digraph,0);
        Queue<DirectedEdge> path = msp.findAsc(6);
        Iterator<DirectedEdge> it = path.iterator();
        assertEquals(4, it.next().to());
        assertEquals( 6, it.next().to());
        assertFalse(it.hasNext());
    }

    @Test
    void decreasingPath() {
        MonotonicShortestPath msp = new MonotonicShortestPath(digraph,0);
        Queue<DirectedEdge> path = msp.findDesc(2);
        Iterator<DirectedEdge> it = path.iterator();
        assertEquals(4, it.next().to());
        assertEquals( 5, it.next().to());
        assertEquals( 2, it.next().to());
        assertFalse(it.hasNext());
    }

    @BeforeAll
    static void setUp(){
        digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new DirectedEdge(0, 1, 5.0));
        digraph.addEdge(new DirectedEdge(0, 4, 9.0));
        digraph.addEdge(new DirectedEdge(0, 7, 8.0));
        digraph.addEdge(new DirectedEdge(1, 2, 12.0));
        digraph.addEdge(new DirectedEdge(1, 3, 15.0));
        digraph.addEdge(new DirectedEdge(1, 7, 4.0));
        digraph.addEdge(new DirectedEdge(2, 3, 3.0));
        digraph.addEdge(new DirectedEdge(2, 6, 11.0));
        digraph.addEdge(new DirectedEdge(3, 6, 9.0));
        digraph.addEdge(new DirectedEdge(4, 5, 4.0));
        digraph.addEdge(new DirectedEdge(4, 6, 20.0));
        digraph.addEdge(new DirectedEdge(4, 7, 5.0));
        digraph.addEdge(new DirectedEdge(5, 2, 1.0));
        digraph.addEdge(new DirectedEdge(5, 6, 13.0));
        digraph.addEdge(new DirectedEdge(7, 5, 6.0));
        digraph.addEdge(new DirectedEdge(7, 2, 7.0));
    }
}