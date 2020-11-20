package org.sedgewick.algorithms.part_one.week_one.question_six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EggDropTest {

    @Test
    void dropFirst() {
        assertEquals(4, new EggDrop().drop(3, 14));
    }

    @Test
    void dropSecond() {
        assertEquals(5, new EggDrop().drop(4, 30));
    }
}