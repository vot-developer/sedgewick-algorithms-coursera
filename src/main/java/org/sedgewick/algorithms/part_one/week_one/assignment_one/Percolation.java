package org.sedgewick.algorithms.part_one.week_one.assignment_one;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final byte[] states;
    private final int size;
    private final WeightedQuickUnionUF uf;
    private int openCount;
    private boolean isPercolates;

    private class State {
        private static final byte OPEN = 1; // 0b001
        private static final byte BORDER = 2; // 0b010
        private static final byte FULL = 4; // 0b100
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1)
            throw new IllegalArgumentException("By convention, the row and column indices are integers between 1 and n");

        states = new byte[n * n];
        size = n;
        uf = new WeightedQuickUnionUF(n * n);
    }

    private int index(int row, int col) {
        return --row * size + --col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateArguments(row, col);
        int index = index(row, col);

        if (states[index] >= State.OPEN)
            return;

        openCount++;
        states[index] = State.OPEN;

        if (row == 1)
            states[index] |= State.FULL;

        if (row == size)
            states[index] |= State.BORDER;

        unionNeighbors(row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateArguments(row, col);
        return states[index(row, col)] >= State.OPEN;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateArguments(row, col);
        int index = index(row, col);
        return states[index] >= State.OPEN && states[uf.find(index)] >= State.FULL;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return isPercolates;
    }

    private void validateArguments(int row, int col) {
        if (row > size || row <= 0 || col > size || col <= 0) {
            throw new IllegalArgumentException("By convention, the row and column indices are integers between 1 and n " + row + ":" + col);
        }
    }

    private void unionNeighbors(int row, int col) {
        int index = index(row, col);

        byte cumulativeState = 0;
        if (row != 1) {
            cumulativeState |= union(index, index(row - 1, col));
        }
        if (row != size) {
            cumulativeState |= union(index, index(row + 1, col));
        }
        if (col != 1) {
            cumulativeState |= union(index, index(row, col - 1));
        }
        if (col != size) {
            cumulativeState |= union(index, index(row, col + 1));
        }

        int rootIndex = uf.find(index);
        cumulativeState |= (byte) (states[rootIndex] | states[index]);
        states[rootIndex] = cumulativeState;

        if (states[rootIndex] >= (State.BORDER | State.FULL))
            isPercolates = true;
    }

    private byte union(int index, int neighborIndex) {
        if (states[neighborIndex] >= State.OPEN) {
            int previousRootIndex = uf.find(neighborIndex);
            uf.union(index, neighborIndex);
            return states[previousRootIndex];
        }
        return 0;
    }
}
