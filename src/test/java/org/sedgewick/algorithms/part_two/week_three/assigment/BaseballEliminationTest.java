package org.sedgewick.algorithms.part_two.week_three.assigment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballEliminationTest {

    @Test
    void isEliminated() {
        BaseballElimination b = new BaseballElimination("teams4.txt");
        assertFalse(b.isEliminated("Atlanta"));
        assertTrue(b.isEliminated("Philadelphia"));
        assertFalse(b.isEliminated("New_York"));
        assertTrue(b.isEliminated("Montreal"));
    }

    @Test
    void certificateOfEliminationIsNullorNot() {
        BaseballElimination b = new BaseballElimination("teams4.txt");
        assertNull(b.certificateOfElimination("Atlanta"));
        assertNotNull(b.certificateOfElimination("Philadelphia"));
        assertNull(b.certificateOfElimination("New_York"));
        assertNotNull(b.certificateOfElimination("Montreal"));
    }
}