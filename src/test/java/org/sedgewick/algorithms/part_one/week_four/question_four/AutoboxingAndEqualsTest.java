package org.sedgewick.algorithms.part_one.week_four.question_four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoboxingAndEqualsTest {
    @Test
    void test1() {
        double a = 0.0;
        double b = -0.0;
        Double x = a;
        Double y = b;
        assertTrue(a == b);
        assertFalse(x.equals(y));
    }

    @Test
    void test2() {
        double a = Double.NaN;
        double b = Double.NaN;
        Double x = a;
        Double y = b;
        assertFalse(a == b);
        assertTrue(x.equals(y));
    }
}
