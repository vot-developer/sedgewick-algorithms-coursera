package org.sedgewick.algorithms.part_two.week_five.question_two;

public class ExponentialSizeDFA {
    private final static int N = 1_000;

    public String getLinearRegexp(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append("(0|1)");
        sb.append("0(0|1)*");
        return sb.toString();
    }

    public String getExponentialRegexp(){
        StringBuilder sb = new StringBuilder("0(0|1)*");
        for (int i = 0; i < N; i++)
            sb.append("(0|1)");
        return sb.toString();
    }

    public String getText(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append("0");
        sb.append("01");
        return sb.toString();
    }
}
