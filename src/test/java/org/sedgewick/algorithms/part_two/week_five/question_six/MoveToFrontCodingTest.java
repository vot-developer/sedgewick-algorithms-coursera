package org.sedgewick.algorithms.part_two.week_five.question_six;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveToFrontCodingTest {

    @Test
    void encode() {
        MoveToFrontCoding moveToFrontCoding = new MoveToFrontCoding();
        assertEquals("151141141", moveToFrontCoding.encode("panama"));
    }

    @Test
    void encodeCornerCase() {
        MoveToFrontCoding moveToFrontCoding = new MoveToFrontCoding();
        assertEquals("02511", moveToFrontCoding.encode("azaz"));
    }
}