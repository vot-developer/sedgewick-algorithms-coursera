package org.sedgewick.algorithms.part_one.week_five.assigment_one;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class KdTreeTest {

    @Test
    void testContains() {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.1, 0.1));
        kdTree.insert(new Point2D(0.2, 0.2));
        kdTree.insert(new Point2D(0.2, 0.3));
        kdTree.insert(new Point2D(0.4, 0.1));
        kdTree.insert(new Point2D(0.2, 0.0));
        kdTree.insert(new Point2D(0.0, 0.5));
        assertEquals(6, kdTree.size());
        assertTrue(kdTree.contains(new Point2D(
                0.2, 0.2
        )));
        assertTrue(kdTree.contains(new Point2D(
                0.2, 0.3
        )));
        assertFalse(kdTree.contains(new Point2D(
                0.2, 0.1
        )));
    }

    @Test
    void testRect() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(0.1, 0.1));
        tree.insert(new Point2D(0.2, 0.2));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.1));
        tree.insert(new Point2D(0.2, 0.0));
        tree.insert(new Point2D(0.0, 0.5));
        RectHV rectHV = new RectHV(0.0, 0.0, 0.2, 0.2);
        Iterable<Point2D> points = tree.range(rectHV);
        Iterator<Point2D> it = points.iterator();
        assertEquals(new Point2D(0.1, 0.1), it.next());
        assertEquals(new Point2D(0.2, 0.2), it.next());
        assertEquals(new Point2D(0.2, 0.0), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testNearest() {
        KdTree tree = new KdTree();
        tree.insert(new Point2D(0.1, 0.1));
        tree.insert(new Point2D(0.2, 0.2));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.1));
        tree.insert(new Point2D(0.2, 0.0));
        tree.insert(new Point2D(0.0, 0.5));
        Point2D nearestPoint = tree.nearest(new Point2D(0.2, 0.4));
        assertEquals(new Point2D(0.2, 0.3), nearestPoint);
    }
}