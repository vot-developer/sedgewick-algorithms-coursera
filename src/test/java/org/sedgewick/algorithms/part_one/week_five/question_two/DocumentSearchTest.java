package org.sedgewick.algorithms.part_one.week_five.question_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentSearchTest {

    @Test
    void search() {
        String[] document = new String[] {"s", "r", "a", "s", "q", "s", "x", "a", "d", "w", "b", "s", "a", "k"};
        String[] indexes = new String[] {"a", "b"};
        int result = new DocumentSearch().search(document, indexes);
        assertEquals(4, result);
    }

    @Test
    void searchNothing() {
        String[] document = new String[] {"s", "r", "a", "s", "q", "s", "x", "a", "d", "w", "b", "s", "a", "k"};
        String[] indexes = new String[] {"a", "b", "w"};
        int result = new DocumentSearch().search(document, indexes);
        assertEquals(-1, result);
    }
}