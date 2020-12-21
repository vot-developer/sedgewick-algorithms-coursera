package org.sedgewick.algorithms.part_two.week_three.question_two;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PerfectMatchingTest {

    @Test
    void isArrange() {
        PerfectMatching pf = new PerfectMatching(8, 7);
        assertTrue(pf.isArrange());
    }

    @Test
    void isArrange100() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int k = random.nextInt(100);
            int n = 0;
            while(n < k)
                n = random.nextInt(100);
            PerfectMatching pf = new PerfectMatching(n, k);
            assertTrue(pf.isArrange());
        }
    }

    @Test
    void cornerCaseLow() {
        PerfectMatching pf = new PerfectMatching(1, 1);
        assertTrue(pf.isArrange());
    }

    @Test
    void cornerCaseHigh() {
        PerfectMatching pf = new PerfectMatching(10, 10);
        assertTrue(pf.isArrange());
    }
}