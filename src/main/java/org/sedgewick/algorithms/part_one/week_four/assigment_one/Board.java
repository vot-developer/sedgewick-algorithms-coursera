package org.sedgewick.algorithms.part_one.week_four.assigment_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private final int[][] tiles;
    private final int dimension;
    private final int hamming;
    private final int manhattan;
    private int zeroX = -1;
    private int zeroY = -1;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null) throw new IllegalArgumentException("Argument is null");
        this.dimension = tiles.length;
        if (dimension < 2 || dimension >= 128) throw new IllegalArgumentException("Argument has wrong size of arrays");

        this.tiles = tiles;

        int hamming = 0;
        int manhattan = 0;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int value = tiles[i][j];
                if (value == 0) {
                    zeroX = i;
                    zeroY = j;
                    continue;
                }
                if (value != i * tiles.length + j + 1) {
                    hamming++;
                    manhattan += Math.abs((value - 1) / tiles.length - i) + Math.abs((value - 1) % tiles.length - j);
                }
            }
            if (tiles[i].length != dimension)
                throw new IllegalArgumentException("Argument has different size of arrays");
        }

        if (zeroX == -1 || zeroY == -1) throw new IllegalArgumentException("Argument doesn't have zero tile");
        this.hamming = hamming;
        this.manhattan = manhattan;
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder("" + dimension);
        for (int i = 0; i < tiles.length; i++) {
            sb.append(System.lineSeparator()).append(' ');
            for (int j = 0; j < tiles[i].length; j++)
                sb.append(tiles[i][j]).append(' ');
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return dimension;
    }

    // number of tiles out of place
    public int hamming() {
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming == 0;
    }

    // does this board equal y?
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> neighbors = new ArrayList<>(4);
        if (zeroX > 0) neighbors.add(swap(zeroX, zeroY, (zeroX - 1), zeroY));
        if (zeroX < dimension - 1) neighbors.add(swap(zeroX, zeroY, (zeroX + 1), zeroY));
        if (zeroY > 0) neighbors.add(swap(zeroX, zeroY, zeroX, (zeroY - 1)));
        if (zeroY < dimension - 1) neighbors.add(swap(zeroX, zeroY, zeroX, (zeroY + 1)));
        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        if (zeroX == 0) return swap(1, 0, 1, 1);
        return swap(0, 0, 0, 1);
    }

    private Board swap(int aX, int aY, int bX, int bY) {
        int[][] result = Arrays.stream(tiles).map(int[]::clone).toArray(int[][]::new);
        int tmp = result[aX][aY];
        result[aX][aY] = result[bX][bY];
        result[bX][bY] = tmp;
        return new Board(result);
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] tiles = {
                {3, 1, 2},
                {4, 5, 0},
                {7, 8, 6},
        };
        Board board = new Board(tiles);
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
        System.out.println(board);
        System.out.println(board.isGoal());
        System.out.println("===========neighbors=============");
        for (Board b : board.neighbors()) {
            System.out.println(b);
        }
        System.out.println("===========twin=============");
        System.out.println(board);
        Board twin = board.twin();
        System.out.println(twin);
    }
}
