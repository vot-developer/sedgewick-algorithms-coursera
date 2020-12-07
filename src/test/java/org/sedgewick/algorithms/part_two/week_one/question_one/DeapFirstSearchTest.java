package org.sedgewick.algorithms.part_two.week_one.question_one;

import edu.princeton.cs.algs4.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DeapFirstSearchTest {
    private static Graph graph;
    /*
    1 - 0 - 6 - 4 - 5 - 3
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
        graph.addEdge(6, 4);
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
        DeapFirstSearch dfs = new DeapFirstSearch(graph, 0);
        assertTrue(dfs.hasToPath(5));
    }

    @Test
    void pathTo() {
        DeapFirstSearch dfs = new DeapFirstSearch(graph, 0);
        Iterator<Integer> it = dfs.pathTo(5).iterator();
        assertEquals(0, it.next());
        assertEquals(6, it.next());
        assertEquals(4, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void cornerCasePathTo() {
        DeapFirstSearch dfs = new DeapFirstSearch(graph, 0);
        Iterator<Integer> it = dfs.pathTo(1).iterator();
        assertEquals(0, it.next());
        assertFalse(it.hasNext());
    }
}