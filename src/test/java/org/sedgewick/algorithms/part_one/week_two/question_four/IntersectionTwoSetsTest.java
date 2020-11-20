package org.sedgewick.algorithms.part_one.week_two.question_four;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionTwoSetsTest {

    @Test
    void findIntersections() {
        Point2D[] a = new Point2D[]{
                new Point2D(1, 2),
                new Point2D(2, 1),
                new Point2D(1, 1),
                new Point2D(2, 2),
                new Point2D(3, 2),
        };
        Point2D[] b = new Point2D[]{
                new Point2D(3, 2),
                new Point2D(3, 3),
                new Point2D(4, 4),
                new Point2D(2, 2),
                new Point2D(1, 1),
        };
        List<Point2D> result = new IntersectionTwoSets().findIntersections(a, b);
        assertArrayEquals(new Point2D[]{
                new Point2D(1, 1),
                new Point2D(2, 2),
                new Point2D(3, 2)
        }, result.toArray());
    }
}