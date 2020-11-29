package org.sedgewick.algorithms.part_one.week_six.question_two;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OlympicAthleteWithHashTest {

    @Test
    void testRightObject() {
        Set<OlympicAthlete> set = new HashSet();
        OlympicAthlete athlete = new OlympicAthlete();
        athlete.name = "name1";
        athlete.sport = "sport1";
        set.add(athlete);

        OlympicAthlete athleteForFind = new OlympicAthlete();
        athleteForFind.name = "name1";
        athleteForFind.sport = "sport1";
        assertTrue(set.contains(athleteForFind));// Equal object found
    }

    @Test
    void testHashWithoutEquals() {
        Set<OlympicAthleteWithHash> set = new HashSet();
        OlympicAthleteWithHash athlete = new OlympicAthleteWithHash();
        athlete.name = "name1";
        athlete.sport = "sport1";
        set.add(athlete);

        OlympicAthleteWithHash athleteForFind = new OlympicAthleteWithHash();
        athleteForFind.name = "name1";
        athleteForFind.sport = "sport1";
        assertFalse(set.contains(athleteForFind)); // Equal object didn't find
    }

    @Test
    void testEqualsWithoutHash() {
        Set<OlympicAthleteWithEquals> set = new HashSet();
        OlympicAthleteWithEquals athlete = new OlympicAthleteWithEquals();
        athlete.name = "name1";
        athlete.sport = "sport1";
        set.add(athlete);

        OlympicAthleteWithEquals athleteForFind = new OlympicAthleteWithEquals();
        athleteForFind.name = "name1";
        athleteForFind.sport = "sport1";
        assertFalse(set.contains(athleteForFind)); // Equal object didn't find
    }

    @Test
    void testWrongEquals() {
        Set<OlympicAthleteWithWrongEquals> set = new HashSet();
        OlympicAthleteWithWrongEquals athlete = new OlympicAthleteWithWrongEquals();
        athlete.name = "name1";
        athlete.sport = "sport1";
        set.add(athlete);

        OlympicAthleteWithWrongEquals athleteForFind = new OlympicAthleteWithWrongEquals();
        athleteForFind.name = "name1";
        athleteForFind.sport = "sport1";
        assertFalse(set.contains(athleteForFind)); // Equal object didn't find
    }
}