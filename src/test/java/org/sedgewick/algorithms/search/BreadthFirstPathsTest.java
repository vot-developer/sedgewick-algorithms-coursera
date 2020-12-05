package org.sedgewick.algorithms.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sedgewick.algorithms.structures.Graph;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstPathsTest {
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
        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        assertTrue(bfp.hasToPath(5));
    }

    @Test
    void pathTo() {
        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        assertArrayEquals(new Integer[]{0, 1, 4}, bfp.pathTo(5).toArray());
    }

    @Test
    void cornerCasePathTo() {
        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        assertArrayEquals(new Integer[]{0}, bfp.pathTo(1).toArray());
    }
}