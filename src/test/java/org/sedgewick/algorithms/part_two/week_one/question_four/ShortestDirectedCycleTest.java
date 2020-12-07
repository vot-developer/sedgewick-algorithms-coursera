package org.sedgewick.algorithms.part_two.week_one.question_four;

import edu.princeton.cs.algs4.Digraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ShortestDirectedCycleTest {
    /*
      0 -> 1
     / <
    <   \
   2 -> 3
     */
    private static Digraph digraph;

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

    private static ShortestDirectedCycle sdc;

    @Test
    void find() {
        assertArrayEquals(new Integer[]{0, 2, 3}, sdc.dfs(digraph).toArray());
    }

    @Test
    void notFind() {
        Digraph digraph = new Digraph(2);
        digraph.addEdge(0, 1);
        assertNull(sdc.dfs(digraph));
    }

    @Test
    void cornerCase() {
        Digraph digraph = new Digraph(2);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 0);
        assertArrayEquals(new Integer[]{0, 1}, sdc.dfs(digraph).toArray());
    }

    @Test
    void findSecond() {
        Collection<Integer> path =  sdc.dfs(graphCycle);
        assertArrayEquals(new Integer[]{4, 2, 3}, path.toArray());
    }

    @BeforeAll
    static void setUp(){
        sdc = new ShortestDirectedCycle();

        digraph = new Digraph(4);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 0);

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
    }
}