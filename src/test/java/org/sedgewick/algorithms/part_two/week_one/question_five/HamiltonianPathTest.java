package org.sedgewick.algorithms.part_two.week_one.question_five;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonianPathTest {
    /*
        1 -> 0 <-> 6 -> 4 -> 5 -> 3
                    <   \ --->  /
                    \
                     >
                      2
     */
    private static Digraph digraph;

    /*
    1 -> 0 <- 6 -> 4 -> 5 -> 3
                <   \ --->  /
                \
                 >
                  2
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
        assertArrayEquals(new Integer[]{1, 0, 6, 2, 4, 5, 3}, hp.getPath().toArray());
    }

    @Test
    void isNotExistHamiltonianPath() {
        HamiltonianPath hp = new HamiltonianPath(digraph2);
        assertFalse(hp.isExistHamiltonianPath());
        assertNull(hp.getPath());
    }

    @BeforeAll
    static void setUp() {
        digraph = new Digraph(7);
        digraph.addEdge(1, 0);
        digraph.addEdge(0, 6);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 2);
        digraph.addEdge(6, 4);
        digraph.addEdge(2, 6);
        digraph.addEdge(4, 5);
        digraph.addEdge(5, 3);
        digraph.addEdge(4, 3);

        digraph2 = new Digraph(7);
        digraph2.addEdge(1, 0);
        digraph2.addEdge(0, 6);
        digraph2.addEdge(6, 2);
        digraph2.addEdge(6, 4);
        digraph2.addEdge(2, 6);
        digraph2.addEdge(4, 5);
        digraph2.addEdge(5, 3);
        digraph2.addEdge(4, 3);
    }
}