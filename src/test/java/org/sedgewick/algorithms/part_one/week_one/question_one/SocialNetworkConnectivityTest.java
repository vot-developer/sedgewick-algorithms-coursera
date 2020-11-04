package org.sedgewick.algorithms.part_one.week_one.question_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkConnectivityTest {

    @Test
    public void test() {
        SocialNetworkConnectivity snc = new SocialNetworkConnectivity(7);
        snc.union(0,5);
        snc.union(1,3);
        snc.union(4,5);
        snc.union(4,6);
        snc.union(6,2);
        snc.union(3,1);
        assertEquals(5, snc.getSize(4));
        snc.union(1,2);
        assertEquals(7, snc.getSize(6));
    }
}