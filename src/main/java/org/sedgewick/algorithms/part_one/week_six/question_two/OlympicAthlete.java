package org.sedgewick.algorithms.part_one.week_six.question_two;

import java.util.Objects;

public class OlympicAthlete {
    String name;
    String sport;

    @Override
    public int hashCode() {
        return Objects.hash(name, sport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OlympicAthlete that = (OlympicAthlete) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(sport, that.sport);
    }
}
