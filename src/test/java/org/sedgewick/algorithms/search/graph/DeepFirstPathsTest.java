package org.sedgewick.algorithms.search.graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.algs4.Graph;
import org.sedgewick.algorithms.search.graph.DeepFirstPaths;

import static org.junit.jupiter.api.Assertions.*;

class DeepFirstPathsTest {
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
    void hasToPath() {
        DeepFirstPaths dfp = new DeepFirstPaths(graph, 0);
        assertTrue(dfp.hasToPath(5));
    }

    @Test
    void pathTo() {
        DeepFirstPaths dfp = new DeepFirstPaths(graph, 0);
        assertArrayEquals(new Integer[]{0, 1, 4}, dfp.pathTo(5).toArray());
    }

    @Test
    void cornerCasePathTo() {
        DeepFirstPaths dfp = new DeepFirstPaths(graph, 0);
        assertArrayEquals(new Integer[]{0}, dfp.pathTo(1).toArray());
    }
}