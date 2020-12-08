package org.sedgewick.algorithms.part_two.week_one.assigment_one;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SAPTest {
    private static Digraph digraph;

    @Test
    void ancestor() {
        SAP sap = new SAP(digraph);
        assertEquals(3, sap.ancestor(7, 16));
    }

    @Test
    void ancestorRoot() {
        SAP sap = new SAP(digraph);
        assertEquals(0, sap.ancestor(13, 24));
    }

    @Test
    void length() {
        SAP sap = new SAP(digraph);
        assertEquals(3, sap.length(7, 16));
    }

    @Test
    void lengthRoot() {
        SAP sap = new SAP(digraph);
        assertEquals(9, sap.length(13, 24));
    }

    @Test
    void ancestorForMany() {
        SAP sap = new SAP(digraph);
        assertEquals(3, sap.ancestor(new HashSet<>(Arrays.asList(13, 23, 24)),
                new HashSet<>(Arrays.asList(6, 16, 17))));
    }

    @BeforeAll
    static void setUp() {
        digraph = new Digraph(25);
        digraph.addEdge(1, 0);
        digraph.addEdge(2, 0);
        digraph.addEdge(3, 1);
        digraph.addEdge(4, 1);
        digraph.addEdge(5, 2);
        digraph.addEdge(6, 2);
        digraph.addEdge(10, 5);
        digraph.addEdge(11, 5);
        digraph.addEdge(12, 5);
        digraph.addEdge(17, 10);
        digraph.addEdge(18, 10);
        digraph.addEdge(19, 12);
        digraph.addEdge(20, 12);
        digraph.addEdge(23, 20);
        digraph.addEdge(7, 3);
        digraph.addEdge(8, 3);
        digraph.addEdge(9, 3);
        digraph.addEdge(13, 7);
        digraph.addEdge(14, 7);
        digraph.addEdge(15, 9);
        digraph.addEdge(16, 9);
        digraph.addEdge(21, 16);
        digraph.addEdge(22, 16);
        digraph.addEdge(24, 20);
    }
}