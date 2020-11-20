package org.sedgewick.algorithms.part_one.week_two.question_four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoSets {

    public List<Point2D> findIntersections(Point2D[] a, Point2D[] b) {
        List<Point2D> intersections = new ArrayList<>();

        if (a.length == 0 || b.length == 0)
            return intersections;

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else if (a[i].compareTo(b[j]) > 0) {
                j++;
            } else {
                intersections.add(a[i]);
                i++;
                j++;
            }
        }
        return intersections;
    }
}
