package org.sedgewick.algorithms.part_two.week_five.question_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExponentialSizeDFATest {
    @Test
    public void test(){
        ExponentialSizeDFA sizeDFA = new ExponentialSizeDFA();
        String text = sizeDFA.getText();

        long start = System.currentTimeMillis();
        assertTrue(text.matches(sizeDFA.getLinearRegexp()));
        long end = System.currentTimeMillis();
        long linearTime = end - start;

        start = System.currentTimeMillis();
        assertTrue(text.matches(sizeDFA.getExponentialRegexp()));
        end = System.currentTimeMillis();
        long exponentialTime = end - start;
        assertTrue(linearTime < exponentialTime);
    }
}