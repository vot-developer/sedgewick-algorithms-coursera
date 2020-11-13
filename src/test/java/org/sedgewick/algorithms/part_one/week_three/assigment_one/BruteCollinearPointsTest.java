package org.sedgewick.algorithms.part_one.week_three.assigment_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruteCollinearPointsTest {

    @Test
    void test() {
        Point[] points = new Point[]{
                new Point(3, 3),
                new Point(3, 2),
                new Point(1, 1),
                new Point(1, 2),
                new Point(0, 0),
                new Point(2, 2),
                new Point(0, 4),
                new Point(3, 7)
        };

        BruteCollinearPoints collinearPoints = new BruteCollinearPoints(points);
        assertEquals(1, collinearPoints.numberOfSegments());
    }
}