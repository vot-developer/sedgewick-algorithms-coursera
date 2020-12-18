package org.sedgewick.algorithms.part_two.week_two.assigment;

import edu.princeton.cs.algs4.Picture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeamCarverTest {

    @Test
    void energy3on4() {
        SeamCarver sc = new SeamCarver(new Picture("/3x4.png"));
        assertEquals(1000.0, sc.energy(0 ,1));
        assertEquals(228.08770243044668, sc.energy(1 ,2));
        assertEquals(228.52789764052878, sc.energy(1 ,1));
    }

    @Test
    void verticalSeam3on4() {
        SeamCarver sc = new SeamCarver(new Picture("/3x4.png"));
        int[] shortestPath = sc.findVerticalSeam();
        assertArrayEquals(new int[]{0, 1, 1, 0}, shortestPath);
    }

    @Test
    void horizontalSeam3on4() {
        SeamCarver sc = new SeamCarver(new Picture("/3x4.png"));
        int[] shortestPath = sc.findHorizontalSeam();
        assertArrayEquals(new int[]{1, 2, 1}, shortestPath);
    }

    @Test
    void removeHorizontalSeam3on4() {
        SeamCarver sc = new SeamCarver(new Picture("/3x4.png"));
        sc.removeHorizontalSeam(sc.findHorizontalSeam());
        int[] shortestPath = sc.findHorizontalSeam();
        assertArrayEquals(new int[]{0, 1, 0}, shortestPath);
    }

    @Test
    void removeVerticalSeam3on4() {
        SeamCarver sc = new SeamCarver(new Picture("/3x4.png"));
        sc.removeVerticalSeam(sc.findVerticalSeam());
        int[] shortestPath = sc.findVerticalSeam();
        assertArrayEquals(new int[]{0, 0, 0, 0}, shortestPath);
    }

    @Test
    void energy6on5() {
        SeamCarver sc = new SeamCarver(new Picture("/6x5.png"));
        assertEquals(1000.0, sc.energy(0 ,4));
        assertEquals(153.8765739155899, sc.energy(1 ,3));
        assertEquals(284.01232367627995, sc.energy(3 ,3));
    }

    @Test
    void verticalSeam6on5() {
        SeamCarver sc = new SeamCarver(new Picture("/6x5.png"));
        int[] shortestPath = sc.findVerticalSeam();
        assertArrayEquals(new int[]{3, 4, 3, 2, 1}, shortestPath);
    }

    @Test
    void horizontalSeam6on5() {
        SeamCarver sc = new SeamCarver(new Picture("/6x5.png"));
        int[] shortestPath = sc.findHorizontalSeam();
        assertArrayEquals(new int[]{1, 2, 1, 2, 1, 0}, shortestPath);
    }
}