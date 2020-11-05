package org.sedgewick.algorithms.part_one.week_one.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double threshold = 1.96;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("arguments must be n ≤ 0 and trials ≤ 0");

        double[] data = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                percolation.open(row, col);
            }
            data[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }

        this.mean = StdStats.mean(data);
        this.stddev = StdStats.stddev(data);
        this.confidenceLo = this.mean - this.stddev * threshold / Math.sqrt(trials);
        this.confidenceHi = this.mean + this.stddev * threshold / Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1])
        );
        StdOut.printf("%-23s = %.7f\n", "mean", ps.mean());
        StdOut.printf("%-23s = %.16f\n", "stddev", ps.stddev());
        StdOut.printf("%-23s = [%.16f, %.16f]\n", "95% confidence interval", ps.confidenceLo(), ps.confidenceHi());
    }
}
