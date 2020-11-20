package org.sedgewick.algorithms.part_one.week_three.assigment_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FastCollinearPointsTest {

    @Test
    void test() {
        Point[] points = new Point[]{
                new Point(3, 2),
                new Point(1, 1),
                new Point(1, 2),
                new Point(3, 3),
                new Point(0, 0),
                new Point(2, 2),
                new Point(0, 4),
                new Point(3, 7)
        };

        FastCollinearPoints collinearPoints = new FastCollinearPoints(points);
        assertEquals(1, collinearPoints.numberOfSegments());
    }

    @Test
    void testOne() {
        Point[] points = new Point[]{
                new Point(9000, 9000),
                new Point(8000, 8000),
                new Point(7000, 7000),
                new Point(6000, 6000),
                new Point(5000, 5000),
                new Point(4000, 4000),
                new Point(3000, 3000),
                new Point(2000, 2000),
                new Point(1000, 1000)
        };

        FastCollinearPoints collinearPoints = new FastCollinearPoints(points);
        assertEquals(1, collinearPoints.numberOfSegments());
    }
}