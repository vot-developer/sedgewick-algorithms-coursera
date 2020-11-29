package org.sedgewick.algorithms.part_one.week_six.question_two;

import java.util.Objects;

public class OlympicAthleteWithEquals {
    String name;
    String sport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OlympicAthleteWithHash that = (OlympicAthleteWithHash) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(sport, that.sport);
    }
}
