package org.sedgewick.algorithms.search.graph;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sedgewick.algorithms.search.graph.KShortPaths;
import org.sedgewick.algorithms.structures.Path;

import static org.junit.jupiter.api.Assertions.*;

class KShortPathsTest {

    private static EdgeWeightedDigraph digraph;

    @Test
    void findShortestPath() {
        KShortPaths kpaths = new KShortPaths(digraph, 0, 2);
        Path path = kpaths.find(6, 1);
        assertArrayEquals(new int[]{4, 5, 2, 6}, path.edges.stream().mapToInt(e -> e.to()).toArray());
    }

    @Test
    void findSecondShortestPath() {
        KShortPaths kpaths = new KShortPaths(digraph, 0, 2);
        Path path = kpaths.find(6, 2);
        assertArrayEquals(new int[]{7, 2, 6}, path.edges.stream().mapToInt(e -> e.to()).toArray());
    }

    @Test
    void findEighthShortestPath() {
        KShortPaths kpaths8 = new KShortPaths(digraph, 0, 8);
        Path path8 = kpaths8.find(6, 8);
        assertArrayEquals(new int[]{7, 2, 3, 6}, path8.edges.stream().mapToInt(e -> e.to()).toArray());

        KShortPaths kpaths100 = new KShortPaths(digraph, 0, 100);
        Path path12 = kpaths100.find(6, 8);
        assertArrayEquals(new int[]{7, 2, 3, 6}, path12.edges.stream().mapToInt(e -> e.to()).toArray());
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