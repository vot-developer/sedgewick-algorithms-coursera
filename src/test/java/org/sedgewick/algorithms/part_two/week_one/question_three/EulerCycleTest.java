package org.sedgewick.algorithms.part_two.week_one.question_three;

import edu.princeton.cs.algs4.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EulerCycleTest {
    /*
    1 - 0 - 6 - 4 - 5 - 3
       /
      2
     */
    private static Graph graph;
    /*
        0 ------- 6
       /\  \     |
      / 1 - 2   |
     /     / \ |
    5     3 - 4
    \        /
     -------
     */
    private static Graph graphCycle;

    private static EulerCycle eulerСycle;

    @Test
    void isNotEulerCycle() {
        assertFalse(eulerСycle.isEulerCycle(graph));
    }

    @Test
    void isEulerCycle() {
        assertTrue(eulerСycle.isEulerCycle(graphCycle));
    }

    @BeforeAll
    static void setUp(){
        graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(6, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);

        graphCycle = new Graph(7);
        graphCycle.addEdge(0, 1);
        graphCycle.addEdge(0, 2);
        graphCycle.addEdge(0, 5);
        graphCycle.addEdge(0, 6);
        graphCycle.addEdge(1, 2);
        graphCycle.addEdge(2, 3);
        graphCycle.addEdge(2, 4);
        graphCycle.addEdge(3, 4);
        graphCycle.addEdge(4, 5);
        graphCycle.addEdge(4, 6);

        eulerСycle = new EulerCycle();
    }
}