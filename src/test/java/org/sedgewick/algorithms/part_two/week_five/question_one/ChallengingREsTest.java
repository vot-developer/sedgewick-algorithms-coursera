package org.sedgewick.algorithms.part_two.week_five.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChallengingREsTest {
    //All strings except 11 or 111.
    @Test
    public void testRegExp1(){
        assertTrue("1".matches(ChallengingREs.REGEXP_1));
        assertTrue("011".matches(ChallengingREs.REGEXP_1));
        assertFalse("11".matches(ChallengingREs.REGEXP_1));
        assertFalse("111".matches(ChallengingREs.REGEXP_1));
        assertTrue("110".matches(ChallengingREs.REGEXP_1));
        assertTrue("1111".matches(ChallengingREs.REGEXP_1));
        assertTrue("1110".matches(ChallengingREs.REGEXP_1));
    }

    //Strings with 1 in every odd-number bit position.
    @Test
    public void testRegExp2(){
        assertTrue("1".matches(ChallengingREs.REGEXP_2));
        assertFalse("011".matches(ChallengingREs.REGEXP_2));
        assertTrue("11".matches(ChallengingREs.REGEXP_2));
        assertTrue("111".matches(ChallengingREs.REGEXP_2));
        assertFalse("110".matches(ChallengingREs.REGEXP_2));
        assertTrue("1111".matches(ChallengingREs.REGEXP_2));
        assertTrue("1110".matches(ChallengingREs.REGEXP_2));
    }

    //Strings with an equal number of 0s and 1s. - looks like impossible for NFA

    //Strings with at least two 0s and at most one 1.
    @Test
    public void testRegExp3(){
        assertFalse("1".matches(ChallengingREs.REGEXP_3));
        assertFalse("011".matches(ChallengingREs.REGEXP_3));
        assertFalse("110".matches(ChallengingREs.REGEXP_3));
        assertTrue("00".matches(ChallengingREs.REGEXP_3));
        assertTrue("001".matches(ChallengingREs.REGEXP_3));
        assertTrue("001000".matches(ChallengingREs.REGEXP_3));
    }

    //Strings that when interpreted as a binary integer are a multiple of 3.. (Hint - build DFA for binary string)
    @Test
    public void testRegExp4(){
        assertTrue("0".matches(ChallengingREs.REGEXP_4));
        assertFalse("1".matches(ChallengingREs.REGEXP_4));
        assertFalse("10".matches(ChallengingREs.REGEXP_4));
        assertTrue("11".matches(ChallengingREs.REGEXP_4));
        assertTrue("011".matches(ChallengingREs.REGEXP_4));
        assertFalse("100".matches(ChallengingREs.REGEXP_4));
        assertFalse("101".matches(ChallengingREs.REGEXP_4));
        assertTrue("110".matches(ChallengingREs.REGEXP_4));
        assertTrue("001100".matches(ChallengingREs.REGEXP_4));
        assertTrue("001100000".matches(ChallengingREs.REGEXP_4));
        assertTrue("10101".matches(ChallengingREs.REGEXP_4));
    }

    //Strings with no two consecutive 1s.
    @Test
    public void testRegExp5(){
        assertTrue("0".matches(ChallengingREs.REGEXP_5));
        assertTrue("1".matches(ChallengingREs.REGEXP_5));
        assertTrue("10".matches(ChallengingREs.REGEXP_5));
        assertFalse("11".matches(ChallengingREs.REGEXP_5));
        assertFalse("011".matches(ChallengingREs.REGEXP_5));
        assertTrue("100".matches(ChallengingREs.REGEXP_5));
        assertTrue("101".matches(ChallengingREs.REGEXP_5));
        assertFalse("110".matches(ChallengingREs.REGEXP_5));
        assertFalse("001100".matches(ChallengingREs.REGEXP_5));
        assertFalse("001100000".matches(ChallengingREs.REGEXP_5));
        assertTrue("10101".matches(ChallengingREs.REGEXP_5));
    }

    //Strings that are palindromes (same forwards and backwards). - looks like impossible for NFA

    //Strings with an equal number of substrings of the form 01 and 10.
    @Test
    public void testRegExp6(){
        assertFalse("0".matches(ChallengingREs.REGEXP_6));
        assertFalse("1".matches(ChallengingREs.REGEXP_6));
        assertFalse("10".matches(ChallengingREs.REGEXP_6));
        assertTrue("101".matches(ChallengingREs.REGEXP_6));
        assertTrue("0110".matches(ChallengingREs.REGEXP_6));
        assertFalse("100".matches(ChallengingREs.REGEXP_6));
        assertFalse("1010".matches(ChallengingREs.REGEXP_6));
        assertFalse("001100".matches(ChallengingREs.REGEXP_6));
        assertFalse("00110".matches(ChallengingREs.REGEXP_6));
        assertTrue("10101".matches(ChallengingREs.REGEXP_6));
        assertTrue("1010101".matches(ChallengingREs.REGEXP_6));
        assertTrue("011010110101".matches(ChallengingREs.REGEXP_6));
    }
}
