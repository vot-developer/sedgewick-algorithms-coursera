package org.sedgewick.algorithms.search.graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sedgewick.algorithms.search.graph.WeightedDigraphPaths;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightedDigraphPathsTest {
    private static EdgeWeightedDigraph digraph;

    @Test
    void findPath() {
        WeightedDigraphPaths wdps = new WeightedDigraphPaths(digraph, 0);
        List<DirectedEdge> path = wdps.findShortest(6);
        assertArrayEquals(new int[]{4, 5, 2, 6}, path.stream().mapToInt(e -> e.to()).toArray());
    }

    @Test
    void findAllPath() {
        WeightedDigraphPaths wdps = new WeightedDigraphPaths(digraph, 0);
        List<WeightedDigraphPaths.Path> paths = wdps.findAllPaths(6);
        assertEquals(22, paths.size());
        assertEquals(25.0, paths.get(0).weight);
        assertEquals(33.0, paths.get(paths.size() - 1).weight);
    }

    @BeforeAll
    static void setUp() {
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