package org.sedgewick.algorithms.part_one.week_three.assigment_one;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final Point[] points;
    private LineSegment[] segments;
    private List<LineSegment> lines = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException("argument can't be null");
        for (Point p : points){
            if (p == null)
                throw new IllegalArgumentException("Any point in argument can't be null");
        }

        this.points = points;
        doCalculations();
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.length;
    }

    // the line segments
    public LineSegment[] segments(){
        return segments;
    }

    private void doCalculations(){
        for (int i = 0; i < points.length; i++){
            Point p = points[i];
            for (int j = i + 1; j < points.length; j++){
                Point q = points[j];
                for (int k = j + 1; k < points.length; k++){
                    Point r = points[k];
                    for (int l = k + 1; l < points.length; l++){
                        Point s = points[l];
                        double pToQ = p.slopeTo(q);
                        if (pToQ == p.slopeTo(r) && pToQ == p.slopeTo(s)){
                            addLine(p, q, r, s);
                        }
                    }
                }
            }
        }

        segments = new LineSegment[lines.size()];
        lines.toArray(segments);
    }

    private void addLine(Point p, Point q, Point r, Point s){
        Point[] points = new Point[]{p, q, r, s};
        Arrays.sort(new Point[]{p, q, r, s}, p.slopeOrder());
        lines.add(new LineSegment(points[0], points[3]));
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
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
        System.out.println(bruteCollinearPoints.numberOfSegments());
        System.out.println(bruteCollinearPoints);

        // draw the points
        StdDraw.enableDoubleBuffering();
//        StdDraw.setXscale(0, 32768);
//        StdDraw.setYscale(0, 32768);
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
