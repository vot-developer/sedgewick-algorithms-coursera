package org.sedgewick.algorithms.part_one.week_six.question_two;

import java.util.Objects;

public class OlympicAthleteWithWrongEquals {
    String name;
    String sport;

    @Override
    public int hashCode() {
        return Objects.hash(name, sport);
    }

    public boolean equals(OlympicAthleteWithWrongEquals o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(name, o.name) &&
                Objects.equals(sport, o.sport);
    }
}
