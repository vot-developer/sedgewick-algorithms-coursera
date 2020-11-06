package org.sedgewick.algorithms.part_one.week_one.assignment_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {

    @Test
    void testBaseScenario() {
        Percolation percolation = new Percolation(3);

        percolation.open(1, 1);
        assertTrue(percolation.isOpen(1, 1));
        assertTrue(percolation.isFull(1, 1));
        assertFalse(percolation.percolates());
        assertEquals(1, percolation.numberOfOpenSites());

        assertFalse(percolation.isOpen(3, 1));
        percolation.open(3, 1);
        assertFalse(percolation.isFull(3, 1));
        assertFalse(percolation.percolates());

        percolation.open(2, 1);
        assertTrue(percolation.isOpen(2, 1));
        assertTrue(percolation.isFull(2, 1));
        assertTrue(percolation.percolates());
        assertEquals(3, percolation.numberOfOpenSites());
    }

    @Test
    void testComplexScenario() {
        Percolation percolation = new Percolation(4);

        percolation.open(1, 1);
        assertTrue(percolation.isOpen(1, 1));
        assertTrue(percolation.isFull(1, 1));
        assertFalse(percolation.percolates());
        assertEquals(1, percolation.numberOfOpenSites());

        assertFalse(percolation.isOpen(3, 1));
        percolation.open(3, 1);
        assertFalse(percolation.isFull(3, 1));
        assertFalse(percolation.percolates());

        assertFalse(percolation.isOpen(4, 1));
        percolation.open(4, 1);
        assertFalse(percolation.isFull(4, 1));
        assertFalse(percolation.percolates());

        percolation.open(2, 1);
        assertTrue(percolation.isOpen(2, 1));
        assertTrue(percolation.isFull(2, 1));
        assertTrue(percolation.percolates());
        assertEquals(4, percolation.numberOfOpenSites());
    }

    @Test
    void testCorner(){
        Percolation percolation = new Percolation(1);
        percolation.open(1, 1);
        assertTrue(percolation.isFull(1, 1));
        assertTrue(percolation.percolates());
    }

    @Test
    void backwashProblem() {
        Percolation percolation = new Percolation(3);

        percolation.open(1, 1);
        percolation.open(3, 1);
        percolation.open(2, 1);
        percolation.open(3, 3);
        assertFalse(percolation.isFull(3, 3));
    }
}