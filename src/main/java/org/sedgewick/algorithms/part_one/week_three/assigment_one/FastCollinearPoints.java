package org.sedgewick.algorithms.part_one.week_three.assigment_one;

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
        return segments.clone();
    }

    private void doCalculations(Point[] points) {
        List<LineSegment> lines = new ArrayList<>();
        Point[] clones = points.clone();
        for (Point origin : points) {
            Arrays.sort(clones, origin.slopeOrder());
            for (int i = 3; i < clones.length; i++) {// 3 - because p - is always first and we will ignore it!
                if (origin.slopeTo(clones[i]) == origin.slopeTo(clones[i - 2])) {
                    i = detectLine(clones, i - 2, origin, origin.slopeTo(clones[i - 2]), lines);
                }
            }
        }

        segments = new LineSegment[lines.size()];
        lines.toArray(segments);
    }

    private int detectLine(Point[] points, int i, Point origin, double slope, List<LineSegment> lines) {
        int start = i;
        i += 3; // 3 already have same slope
        for (; i < points.length; i++){
            if (origin.slopeTo(points[i]) != slope){
                break;
            }
        }
        Point[] line = new Point[i - start + 1];
        line[0] = origin;
        System.arraycopy(points, start, line, 1, i - start);
        Arrays.sort(line);
        if (line[0].compareTo(origin) == 0) { // ignore doubles, add only if p is minimum
            lines.add(new LineSegment(line[0], line[line.length - 1]));
        }
        return i + 1; //i - don't included in line and need check in loop, in loop will be ++ (will +2) and finally check (i+2) - 2
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
}
