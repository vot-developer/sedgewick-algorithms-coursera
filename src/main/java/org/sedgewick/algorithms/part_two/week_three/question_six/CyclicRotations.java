package org.sedgewick.algorithms.part_two.week_three.question_six;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CyclicRotations {

    /*
    time - O (n * N * Log L).
    for O(N * n * L) - compare strings with equals hash - char by char (without map structure).
    N - max count of match for one a[i].
     */
    public List<List<String>> find(String[] a) {
        List<List<String>> result = new ArrayList<>();
        CyclicElement[] elements = new CyclicElement[a.length];
        //O(n*L)
        for (int i = 0; i < a.length; i++)
            elements[i] = new CyclicElement(a[i], i);

        // O (4 * n) ~ O(n)
        sortHashByBytes(elements);

        // O (n * N * Log N)
        for (int i = 1; i < a.length; i++)
            if (elements[i - 1].hash == elements[i].hash && elements[i - 1].isCyclicRotation(elements[i])) {
                List<String> rotations = new ArrayList<>();
                rotations.add(a[elements[i - 1].index]);
                while(elements[i - 1].hash == elements[i].hash && elements[i - 1].isCyclicRotation(elements[i])){
                    rotations.add(a[elements[i].index]);
                    i++;
                }
                result.add(rotations);
            }
        return result;
    }

    private void sortHashByBytes(CyclicElement[] a) {
        int R = 256; //8 byte in byte (2^8), we will take one last byte and sort by it
        int W = 4; //for long - 8 bytes (will do shift on 8 bites on each iteration)
        int n = a.length;
        CyclicElement[] aux = new CyclicElement[n];

        for (int d = 0; d < W; d++) {
            int[] count = new int[R + 1];
            //making index
            for (int i = 0; i < n; i++) {
                int c = ((a[i].hash >> 8 * d) & 0b1111_1111); //shift and take d-th byte (8 bit)
                count[c + 1]++;
            }

            //doing count
            for (int r = 0; r < count.length - 1; r++)
                count[r + 1] += count[r];

            //making result
            for (int i = 0; i < n; i++) {
                int c = ((a[i].hash >> 8 * d) & 0b1111_1111);
                aux[count[c]++] = a[i]; //increment count because for same value need different position in result
            }

            //copy
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }

    private class CyclicElement {
        private final String value;
        private final int index;
        private final int hash;
        private final Set<String> rotations;

        // O(L)
        public CyclicElement(String value, int index) {
            this.value = value;
            this.index = index;

            int hash = 0;
            for (char c : value.toCharArray())
                hash += Math.pow((c - 97), 3);
            this.hash = hash;

            rotations = new HashSet<>(value.length());
            for (int i = 0; i < value.length(); i++) {
                char[] r = new char[value.length()];
                System.arraycopy(value.toCharArray(), i, r, 0, value.length() - i);
                System.arraycopy(value.toCharArray(), 0, r, value.length() - i, i);
                rotations.add(new String(r));
            }
        }

        // average O(1), worst - O(log L)
        public boolean isCyclicRotation(CyclicElement ce) {
            return rotations.contains(ce.value);
        }
    }
}
