package org.sedgewick.algorithms.part_one.week_five.assigment_one;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PointSETTest {

    @Test
    void testRect() {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(1, 1));
        pointSET.insert(new Point2D(2, 2));
        pointSET.insert(new Point2D(2, 3));
        pointSET.insert(new Point2D(4, 1));
        pointSET.insert(new Point2D(2, 0));
        pointSET.insert(new Point2D(0, 5));
        RectHV rectHV = new RectHV(0, 0, 2, 2);
        Iterable<Point2D> points = pointSET.range(rectHV);
        Iterator<Point2D> it = points.iterator();
        assertEquals(new Point2D(2, 0), it.next());
        assertEquals(new Point2D(1, 1), it.next());
        assertEquals(new Point2D(2, 2), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testNearest() {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(1, 1));
        pointSET.insert(new Point2D(2, 2));
        pointSET.insert(new Point2D(2, 3));
        pointSET.insert(new Point2D(4, 1));
        pointSET.insert(new Point2D(2, 0));
        pointSET.insert(new Point2D(0, 5));
        Point2D nearestPoint = pointSET.nearest(new Point2D(2, 4));
        assertEquals(new Point2D(2, 3), nearestPoint);
    }
}