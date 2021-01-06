package org.sedgewick.algorithms.part_two.week_four.assigment;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoggleSolverTest {

    @Test
    void test() {
        BoggleBoard board = new BoggleBoard("board4x2.txt");
        BoogleTree tree = new BoogleTree(board);
        assertTrue(tree.find("TAPIDETA"));
    }

    @Test
    void test2() {
        BoggleBoard board = new BoggleBoard("board4x2.txt");
        BoogleTree tree = new BoogleTree(board);
        assertFalse(tree.find("TAPIDETPA"));
    }

    @Test
    void board4on4() {
        In in = new In("dictionary-algs4.txt");
        String[] dictionary = in.readAllStrings();
        BoggleSolver boggleSolver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard("board4x4.txt");
        Iterable<String> it = boggleSolver.getAllValidWords(board);
        int score = 0;
        for (String word : it)
            score += boggleSolver.scoreOf(word);
        assertEquals(33, score);
    }

    @Test
    void boardQ() {
        In in = new In("dictionary-algs4.txt");
        String[] dictionary = in.readAllStrings();
        BoggleSolver boggleSolver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard("board-q.txt");
        Iterable<String> it = boggleSolver.getAllValidWords(board);
        int score = 0;
        for (String word : it)
            score += boggleSolver.scoreOf(word);
        assertEquals(84, score);
    }
}