package org.sedgewick.algorithms.part_one.week_three.assigment_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void slopeOfEquals() {
        Point p = new Point(400, 1);
        Point q = new Point(400, 1);
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(q));
    }
}