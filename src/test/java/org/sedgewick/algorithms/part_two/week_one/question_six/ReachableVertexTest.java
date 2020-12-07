package org.sedgewick.algorithms.part_two.week_one.question_six;

import edu.princeton.cs.algs4.Digraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReachableVertexTest {
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

    /*
        0 ------- 6
       /\  \     |
      / 1 - 2   |
     /     / \ |
    5     3 - 4
    \        /
     -------
     */
    private static Digraph graphCycle;

    /*
      3 -> 1
     / <
    <   \
   2 -> 0
     */
    private static Digraph graphCycle2;

    @Test
    void isReachableVertexDAG() {
        ReachableVertex rv = new ReachableVertex();
        assertEquals(3, rv.find(digraph));
    }

    @Test
    void isNotReachableVertexDAG() {
        ReachableVertex rv = new ReachableVertex();
        assertEquals(-1, rv.find(digraph2));
    }

    @Test
    void isReachableVertex() {
        ReachableVertex rv = new ReachableVertex();
        assertEquals(0, rv.find(graphCycle));
    }

    @Test
    void isReachableVertex2() {
        ReachableVertex rv = new ReachableVertex();
        assertEquals(1, rv.find(graphCycle2));
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

        graphCycle = new Digraph(7);
        graphCycle.addEdge(0, 1);
        graphCycle.addEdge(1, 2);
        graphCycle.addEdge(2, 0);
        graphCycle.addEdge(0, 5);
        graphCycle.addEdge(6, 0);
        graphCycle.addEdge(2, 3);
        graphCycle.addEdge(3, 4);
        graphCycle.addEdge(4, 2);
        graphCycle.addEdge(5, 4);
        graphCycle.addEdge(4, 6);

        graphCycle2 = new Digraph(4);
        graphCycle2.addEdge(3, 1);
        graphCycle2.addEdge(3, 2);
        graphCycle2.addEdge(2, 0);
        graphCycle2.addEdge(0, 3);
    }
}