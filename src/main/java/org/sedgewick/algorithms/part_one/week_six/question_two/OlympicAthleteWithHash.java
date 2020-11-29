package org.sedgewick.algorithms.part_one.week_six.question_two;

import java.util.Objects;

public class OlympicAthleteWithHash {
    String name;
    String sport;

    @Override
    public int hashCode() {
        return Objects.hash(name, sport);
    }
}
