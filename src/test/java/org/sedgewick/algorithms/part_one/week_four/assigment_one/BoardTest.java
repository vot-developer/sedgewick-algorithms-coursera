package org.sedgewick.algorithms.part_one.week_four.assigment_one;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void dimensionAndManhattan() {
        int[][] tiles = {
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 6},
        };
        Board board = new Board(tiles);
        assertEquals(1, board.hamming());
        assertEquals(1, board.manhattan());
    }

    @Test
    void dimensionAndManhattan2() {
        int[][] tiles = {
                {0, 1, 3},
                {4, 2, 5},
                {7, 8, 6},
        };
        Board board = new Board(tiles);
        assertEquals(4, board.manhattan());
    }

    @Test
    void neighbors() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 6},
        });
        List<Board> neighbors = new ArrayList<>();
        board.neighbors().forEach(neighbors::add);

        assertEquals(new Board(new int[][]{
                {1, 2, 0},
                {4, 5, 3},
                {7, 8, 6},
        }), neighbors.get(0));

        assertEquals(new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        }), neighbors.get(1));

        assertEquals(new Board(new int[][]{
                {1, 2, 3},
                {4, 0, 5},
                {7, 8, 6},
        }), neighbors.get(2));
    }

    @Test
    void twins() {
        Board board = new Board(new int[][]{
                {1, 2, 3},
                {4, 5, 0},
                {7, 8, 6},
        });

        assertEquals(new Board(new int[][]{
                {2, 1, 3},
                {4, 5, 0},
                {7, 8, 6},
        }), board.twin());
    }

    @Test
    void twins2() {
        Board board = new Board(new int[][]{
                {0, 2, 3},
                {4, 5, 1},
                {7, 8, 6},
        });

        assertEquals(new Board(new int[][]{
                {0, 2, 3},
                {5, 4, 1},
                {7, 8, 6},
        }), board.twin());
    }

}