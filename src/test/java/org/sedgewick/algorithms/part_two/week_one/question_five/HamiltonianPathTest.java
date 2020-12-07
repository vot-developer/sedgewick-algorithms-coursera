package org.sedgewick.algorithms.part_two.week_one.question_five;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonianPathTest {
    /*
        1 -> 0 -> 2 -> 4 -> 5 -> 3
                       \ --->  /
     */
    private static Digraph digraph;

    /*
        1 -> 0 <- 2 -> 4 -> 5 -> 3
                       \ --->  /
     */
    private static Digraph digraph2;

    @Test
    void isExistHamiltonianPath() {
        HamiltonianPath hp = new HamiltonianPath(digraph);
        assertTrue(hp.isExistHamiltonianPath());
    }

    @Test
    void testPath() {
        HamiltonianPath hp = new HamiltonianPath(digraph);
        assertArrayEquals(new Integer[]{1, 0, 2, 4, 5, 3}, hp.getPath().toArray());
    }

    @Test
    void isNotExistHamiltonianPath() {
        HamiltonianPath hp = new HamiltonianPath(digraph2);
        assertFalse(hp.isExistHamiltonianPath());
        assertNull(hp.getPath());
    }

    @BeforeAll
    static void setUp() {
        digraph = new Digraph(6);
        digraph.addEdge(1, 0);
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(5, 3);
        digraph.addEdge(4, 3);

        digraph2 = new Digraph(6);
        digraph2.addEdge(1, 0);
        digraph2.addEdge(2, 0);
        digraph2.addEdge(2, 4);
        digraph2.addEdge(4, 5);
        digraph2.addEdge(5, 3);
        digraph2.addEdge(4, 3);
    }
}