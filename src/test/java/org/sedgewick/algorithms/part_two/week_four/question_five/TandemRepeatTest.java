package org.sedgewick.algorithms.part_two.week_four.question_five;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TandemRepeatTest {

    @Test
    void findRepeat() {
        TandemRepeat tandemRepeat = new TandemRepeat("abcab");
        assertEquals(2, tandemRepeat.findRepeat("abcabcababcaba"));
    }

    @Test
    void notFindRepeat() {
        TandemRepeat tandemRepeat = new TandemRepeat("abcabcababcaba");
        assertEquals(0, tandemRepeat.findRepeat("abcab"));
    }

    @Test
    void cornerCase() {
        TandemRepeat tandemRepeat = new TandemRepeat("w");
        assertEquals(1, tandemRepeat.findRepeat("w"));
    }
}