package org.sedgewick.algorithms.part_one.week_three.assigment_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private LineSegment[] segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        validate(points);

        doCalculations(points);
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.clone();
    }

    private void doCalculations(Point[] points) {
        List<LineSegment> lines = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n - 3; i++) {
            Point p = points[i];
            for (int j = i + 1; j < n - 2; j++) {
                Point q = points[j];
                for (int k = j + 1; k < n - 1; k++) {
                    Point r = points[k];
                    for (int l = k + 1; l < n; l++) {
                        Point s = points[l];
                        double pq = p.slopeTo(q);
                        if (pq == p.slopeTo(r) && pq == p.slopeTo(s)) {
                            addLine(p, q, r, s, lines);
                        }
                    }
                }
            }
        }

        segments = new LineSegment[lines.size()];
        lines.toArray(segments);
    }

    private void validate(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("argument can't be null");
        for (Point p : points) {
            if (p == null)
                throw new IllegalArgumentException("Any point in argument can't be null");
        }

        Point[] clones = points.clone();
        Arrays.sort(clones);
        for (int i = 1, n = clones.length; i < n; i++) {
            if (clones[i].compareTo(clones[i - 1]) == 0)
                throw new IllegalArgumentException("Any point in argument can't be equal");
        }
    }

    private void addLine(Point p, Point q, Point r, Point s, List<LineSegment> lines) {
        Point[] points = new Point[]{p, q, r, s};
        Arrays.sort(points);
        lines.add(new LineSegment(points[0], points[3]));
    }
}
