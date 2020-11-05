package org.sedgewick.algorithms.part_one.week_one.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[] isOpen;
    private final int size;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufOneVirtualSite;
    private final int topIndex;
    private final int bottomIndex;
    private int openCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1)
            throw new IllegalArgumentException("By convention, the row and column indices are integers between 1 and n");

        isOpen = new boolean[n * n];
        size = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        ufOneVirtualSite = new WeightedQuickUnionUF(n * n + 1);
        topIndex = n * n;
        bottomIndex = n * n + 1;
    }

    private int index(int row, int col) {
        row--;
        col--;
        return row * size + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateArguments(row, col);
        int index = index(row, col);

        if (isOpen[index])
            return;

        openCount++;
        isOpen[index] = true;

        unionWithNeighbors(row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateArguments(row, col);
        return isOpen[index(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateArguments(row, col);
        return ufOneVirtualSite.find(topIndex) == ufOneVirtualSite.find(index(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(topIndex) == uf.find(bottomIndex);
    }

    private void validateArguments(int row, int col) {
        if (row > size || row <= 0 || col > size || col <= 0) {
            throw new IllegalArgumentException("By convention, the row and column indices are integers between 1 and n " + row + ":" + col);
        }
    }

    private void unionWithNeighbors(int row, int col) {
        int index = index(row, col);
        if (row == 1) {
            uf.union(topIndex, index);
            ufOneVirtualSite.union(topIndex, index);
        }
        if (row == size) {
            uf.union(bottomIndex, index);
        }

        if (row != 1) {
            unionIfOpen(index, index(row - 1, col));
        }
        if (row != size) {
            unionIfOpen(index, index(row + 1, col));
        }
        if (col != 1) {
            unionIfOpen(index, index(row, col - 1));
        }
        if (col != size) {
            unionIfOpen(index, index(row, col + 1));
        }
    }

    private void unionIfOpen(int openedIndex, int neighborIndex) {
        if (isOpen[neighborIndex]) {
            uf.union(openedIndex, neighborIndex);
            ufOneVirtualSite.union(openedIndex, neighborIndex);
        }
    }
}
