package org.sedgewick.algorithms.part_two.week_two.question_five;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sedgewick.algorithms.structures.Path;

import static org.junit.jupiter.api.Assertions.*;

class SecondShortestPathTest {
    private static SecondShortestPath ssp;
    private static EdgeWeightedDigraph digraph;

    @Test
    void find() {
        Path path = ssp.find(digraph, 0, 6);
        assertEquals(26.0, path.weight);
        assertArrayEquals(new int[]{7, 2, 6}, path.edges.stream().mapToInt(e -> e.to()).toArray());
    }

    @BeforeAll
    static void setUp(){
        ssp = new SecondShortestPath();
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