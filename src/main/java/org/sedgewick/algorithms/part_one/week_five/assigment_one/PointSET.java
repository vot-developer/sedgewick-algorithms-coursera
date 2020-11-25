package org.sedgewick.algorithms.part_one.week_five.assigment_one;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class PointSET {
    private final TreeSet<Point2D> tree;

    public PointSET() {
        tree = new TreeSet<>();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public int size() {
        return tree.size();
    }

    public void insert(Point2D p) {
        validate(p);
        tree.add(p);
    }

    public boolean contains(Point2D p) {
        validate(p);
        return tree.contains(p);
    }

    public void draw() {
        Iterator<Point2D> it = tree.iterator();
        while (it.hasNext()) it.next().draw();
    }

    public Iterable<Point2D> range(RectHV rect) {
        validate(rect);
        List<Point2D> result = new ArrayList<>();
        Iterator<Point2D> it = tree.iterator();
        while (it.hasNext()){
            Point2D p = it.next();
            if (rect.contains(p)) result.add(p);
        }
        return result;
    }

    public Point2D nearest(Point2D p) {
        validate(p);
        Point2D nearest = null;
        double min = Double.MAX_VALUE;
        Iterator<Point2D> it = tree.iterator();
        while (it.hasNext()){
            Point2D current = it.next();
            double distance = p.distanceTo(current);
            if (distance < min){
                nearest = current;
                min = distance;
            }
        }
        return nearest;
    }

    private void validate(Object o){
        if (o == null)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

    }
}
