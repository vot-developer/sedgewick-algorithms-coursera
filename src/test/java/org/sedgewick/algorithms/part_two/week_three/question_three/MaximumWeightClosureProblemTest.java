package org.sedgewick.algorithms.part_two.week_three.question_three;

import edu.princeton.cs.algs4.Digraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumWeightClosureProblemTest {
    private static Digraph digraph;
    private static double[] weights;
    private static MaximumWeightClosureProblem closureProblem;

    @Test
    void test(){
        List<Integer> result = closureProblem.findMaximumClosedSubset(digraph, weights);
        assertArrayEquals(new Object[]{3, 5, 6, 7}, result.toArray());
    }

    @BeforeAll
    static void setUp() {
        //vertex 0 is 1 node from pic and etc.
        digraph = new Digraph(8);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(1, 2);
        digraph.addEdge(4, 2);
        digraph.addEdge(5, 3);
        digraph.addEdge(3, 7);
        digraph.addEdge(6, 7);
        digraph.addEdge(6, 5);

        weights = new double[8];
        weights[0] = 1;
        weights[1] = -2;
        weights[2] = -6;
        weights[3] = -4;
        weights[4] = 5;
        weights[5] = 6;
        weights[6] = 7;
        weights[7] = -8;

        closureProblem = new MaximumWeightClosureProblem();
    }
}