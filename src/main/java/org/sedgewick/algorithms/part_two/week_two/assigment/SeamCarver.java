package org.sedgewick.algorithms.part_two.week_two.assigment;

import edu.princeton.cs.algs4.Picture;

import java.awt.Color;

public class SeamCarver {
    private static final double BORDER_ENERGY = 1000;
    private Picture picture;
    private double[][] energy;
    private boolean isTransposed;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        validate(picture);
        this.picture = new Picture(picture);
        calculateEnergy();
    }

    // current picture
    public Picture picture() {
        return new Picture(picture);
    }

    // width of current picture
    public int width() {
        return picture.width();
    }

    // height of current picture
    public int height() {
        return picture.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        validate(x, y);

        if (isTransposed)
            return energy[y][x];
        return energy[x][y];
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        if (!isTransposed)
            transpose();
        return findSeam();
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        if (isTransposed)
            transpose();
        return findSeam();
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        validateHorizontalSeam(seam);

        if (isTransposed) // return to original
            transpose();

        Picture old = picture;
        picture = new Picture(old.width(), old.height() - 1);

        for (int i = 0; i < old.width(); i++) {
            for (int j = 0, row = 0; j < old.height(); j++) {
                if (j != seam[i])
                    picture.setRGB(i, row++, old.getRGB(i, j));
            }
        }

        calculateEnergy();
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        validateVerticalSeam(seam);

        if (isTransposed) // return to original
            transpose();

        Picture old = picture;
        picture = new Picture(old.width() - 1, old.height());

        for (int j = 0; j < old.height(); j++) {
            for (int i = 0, column = 0; i < old.width(); i++) {
                if (i != seam[j])
                    picture.setRGB(column++, j, old.getRGB(i, j));
            }
        }

        calculateEnergy();
    }

    /**
     * Find seem from top to bottom (do vertical seam).
     */
    private int[] findSeam() {
        int[][] edgeTo = new int[energy.length][energy[0].length];

        double[][] distTo = new double[energy.length][energy[0].length];
        for (int i = 0; i < energy.length; i++)
            for (int j = 0; j < energy[i].length; j++) {
                if (j == 0) distTo[i][j] = BORDER_ENERGY;
                else distTo[i][j] = Double.POSITIVE_INFINITY;
            }

        // relax
        for (int j = 0; j < energy[0].length - 1; j++) // rows
            for (int i = 0; i < energy.length; i++) // columns
                relaxAdjacents(i, j, edgeTo, distTo);

        return findShortestPath(edgeTo, distTo);
    }

    private void transpose() {
        double[][] result = new double[energy[0].length][energy.length];

        for (int i = 0; i < energy.length; i++) {
            for (int j = 0; j < energy[0].length; j++)
                result[j][i] = energy[i][j];
        }
        energy = result;
        isTransposed = !isTransposed;
    }

    private void relaxAdjacents(int column, int row, int[][] edgeTo, double[][] distTo) {
        if (column > 0)
            relax(column, column - 1, row, row + 1, edgeTo, distTo);
        if (column < energy.length - 1)
            relax(column, column + 1, row, row + 1, edgeTo, distTo);

        relax(column, column, row, row + 1, edgeTo, distTo);
    }

    private void relax(int columnFrom, int columnTo, int rowFrom, int rowTo, int[][] edgeTo, double[][] distTo) {
        if (distTo[columnTo][rowTo] > distTo[columnFrom][rowFrom] + energy[columnTo][rowTo]) {
            distTo[columnTo][rowTo] = distTo[columnFrom][rowFrom] + energy[columnTo][rowTo];
            edgeTo[columnTo][rowTo] = columnFrom;
        }
    }

    private int[] findShortestPath(int[][] edgeTo, double[][] distTo) {
        double lastMin = Double.POSITIVE_INFINITY;
        int minIndex = -1;
        for (int i = 0; i < distTo.length; i++)
            if (lastMin > distTo[i][distTo[0].length - 1]) {
                lastMin = distTo[i][distTo[0].length - 1];
                minIndex = i;
            }

        int[] result = new int[edgeTo[0].length];
        for (int i = edgeTo[0].length - 1; i >= 0; i--) {
            result[i] = minIndex;
            minIndex = edgeTo[minIndex][i];
        }
        return result;
    }

    //  unit testing (optional)
    public static void main(String[] args) {

    }

    private void calculateEnergy() {
        energy = new double[picture.width()][picture.height()];

        for (int i = 0; i < energy.length; i++)
            for (int j = 0; j < energy[i].length; j++) {
                energy[i][j] = calculateEnergy(i, j);
            }
    }

    private double calculateEnergy(int x, int y) {
        if (x == 0 || x == energy.length - 1 || y == 0 || y == energy[x].length - 1)
            return BORDER_ENERGY;

        Color xm = picture.get(x - 1, y);
        Color xp = picture.get(x + 1, y);
        double rxSq = Math.pow(getRed(xm) - getRed(xp), 2);
        double gxSq = Math.pow(getGreen(xm) - getGreen(xp), 2);
        double bxSq = Math.pow(getBlue(xm) - getBlue(xp), 2);

        Color ym = picture.get(x, y - 1);
        Color yp = picture.get(x, y + 1);
        double rySq = Math.pow(getRed(ym) - getRed(yp), 2);
        double gySq = Math.pow(getGreen(ym) - getGreen(yp), 2);
        double bySq = Math.pow(getBlue(ym) - getBlue(yp), 2);

        return Math.sqrt(rxSq + gxSq + bxSq + rySq + gySq + bySq);
    }

    private void validate(int x, int y) {
        if (x < 0 || x > picture.width() - 1 || y < 0 || y > picture.height() - 1)
            throw new IllegalArgumentException("x or y is outside its prescribed range");
    }

    private void validate(Object o) {
        if (o == null)
            throw new IllegalArgumentException("called with a null argument");
    }

    private void validateHorizontalSeam(int[] seam) {
        validate(seam);
        validateSeam(seam, false);
    }

    private void validateVerticalSeam(int[] seam) {
        validate(seam);
        validateSeam(seam, true);
    }

    private void validateSeam(int[] seam, boolean isVertical) {
        int a = isVertical ? height() : width();
        int b = isVertical ? width() : height();

        if (seam.length != a) {
            throw new IllegalArgumentException("invalid seam length");
        }

        if (seam[0] < 0 || seam[0] >= b)
            throw new IllegalArgumentException("invalid value - out of border");

        for (int i = 1, n = seam.length; i < n; i++) {
            if (seam[i] < 0 || seam[i] >= b)
                throw new IllegalArgumentException("invalid value - out of border");

            if (Math.abs(seam[i] - seam[i - 1]) > 1)
                throw new IllegalArgumentException("invalid value - range or two adjacent entries differ by more than 1");
        }
    }

    private int getRed(Color color) {
        return (color.getRGB() >> 16) & 0xFF;
    }

    private int getGreen(Color color) {
        return (color.getRGB() >> 8) & 0xFF;
    }

    private int getBlue(Color color) {
        return (color.getRGB() >> 0) & 0xFF;
    }
}
