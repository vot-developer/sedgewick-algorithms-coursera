package org.sedgewick.algorithms.part_one.week_three.assigment_one;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private LineSegment[] segments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        validate(points);
        if (points.length > 0) {
            doCalculations(points);
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return segments;
    }

    private void doCalculations(Point[] points) {
        List<LineSegment> lines = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            Point[] clones = new Point[points.length - 1];
            System.arraycopy(points, 0, clones, 0, i);
            System.arraycopy(points, i + 1, clones, i, points.length - i - 1);
            Arrays.sort(clones, p.slopeOrder());
            for (int j = 2; j < clones.length; j++) {
                if (p.slopeTo(clones[j]) == p.slopeTo(clones[j - 2])) {
                    addLine(p, clones[j], clones[j - 1], clones[j - 2], lines);
                }
            }
        }

        segments = new LineSegment[lines.size()];
        lines.toArray(segments);
    }

    private void addLine(Point p, Point q, Point r, Point s, List<LineSegment> lines) {
        Point[] points = new Point[]{p, q, r, s};
        Arrays.sort(points);
        lines.add(new LineSegment(points[0], points[3]));
    }

    private void validate(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("argument can't be null");
        for (Point p : points) {
            if (p == null)
                throw new IllegalArgumentException("Any point in argument can't be null");
        }

        Arrays.sort(points);
        for (int i = 1, n = points.length; i < n; i++) {
            if (points[i].compareTo(points[i - 1]) == 0)
                throw new IllegalArgumentException("Any point in argument can't be equal");
        }
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(3, 3),
                new Point(3, 2),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 2),
                new Point(0, 0),
                new Point(0, 4),
                new Point(3, 7)
        };
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        System.out.println(collinear.numberOfSegments());
        System.out.println(collinear);

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
