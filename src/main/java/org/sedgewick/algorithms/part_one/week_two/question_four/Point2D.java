package org.sedgewick.algorithms.part_one.week_two.question_four;

import java.util.Objects;

public class Point2D implements Comparable<Point2D> {
    final int x;
    final int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x &&
                y == point2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point2D o) {
        if (x == o.x) {
            return y - o.y;
        } else {
            return x - o.x;
        }
    }
}
