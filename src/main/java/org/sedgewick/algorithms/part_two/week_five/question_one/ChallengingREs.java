package org.sedgewick.algorithms.part_two.week_five.question_one;

public class ChallengingREs {
    //All strings except 11 or 111.
    public static final String REGEXP_1 = "0.*|1|10.*|110.*|111.+";
    //Strings with 1 in every odd-number bit position.
    public static final String REGEXP_2 = "1|(1(.{1}1)*.?)";
    //Strings with at least two 0s and at most one 1.
    public static final String REGEXP_3 = "0*|100+|0+10+|00+10*";
    //Strings that when interpreted as a binary integer are a multiple of 3. (Hint - build DFA for binary string)
    public static final String REGEXP_4 = "0*|0*(11)*0*|0*((1(01*0)*1)*0*)*";
    //Strings with no two consecutive 1s.
    public static final String REGEXP_5 = "1|0*((10)*)0*1?";
    //Strings with an equal number of substrings of the form 01 and 10.
    public static final String REGEXP_6 = "((0110)+|(1001)+|(101)+|1(01)+)*";
}
