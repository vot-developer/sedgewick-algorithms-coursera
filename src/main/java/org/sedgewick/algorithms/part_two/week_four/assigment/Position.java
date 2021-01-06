package org.sedgewick.algorithms.part_two.week_four.assigment;

import java.util.Objects;

class Position {
    private final int y;
    private final int x;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int y() {
        return y;
    }

    public int x() {
        return x;
    }

    @Override
    public boolean equals(Object p) {
        if (p == null) return false;
        if (this == p) return true;
        if (this.getClass() != p.getClass()) return false;
        Position position = (Position) p;
        return y == position.y && x == position.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
