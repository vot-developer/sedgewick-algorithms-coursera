package org.sedgewick.algorithms.part_two.week_three.question_four;

import org.sedgewick.algorithms.sort.LSD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

    /*
    time - O(r*n), where r is size of result. Could be O(n) if find only one pair (here more common case)
    space - O(n)
     */
    public List<Integer> findTwoSum(long[] a, long T) {
        long[] aux = Arrays.copyOf(a, a.length);
        LSD.sortByByte(aux);

        Set<Long> terms = new HashSet<>();
        int l = 0, r = aux.length - 1;
        while (l < r) {
            if (aux[l] + aux[r] > T)
                r--;
            else if (aux[l] + aux[r] < T)
                l++;
            else if (aux[l] + aux[r] == T) {
                terms.add(aux[l]); //break and return here if need only one pair
                terms.add(aux[r]);
                l++;
            }
        }

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            for (long j : terms) //O(1) if find only one pair, but this case O(r*n)
                if (a[i] == j)
                    indexes.add(i);

        return indexes;
    }

    /*
     time - O(W * n) - O(8 * n)
     space - O(R + n) - O(256 + n * long)
     copied from org.sedgewick.algorithms.sort.LSD
     */
    private void sortByByte(long[] a) {
        int R = 256; //8 byte in byte (2^8), we will take one last byte and sort by it
        int W = 8; //for long - 8 bytes (will do shift on 8 bites on each iteration)
        int n = a.length;
        long[] aux = new long[n];

        for (int d = 0; d < W; d++) {
            int[] count = new int[R + 1];
            //making index
            for (int i = 0; i < n; i++) {
                int c = (int) ((a[i] >> 8 * d) & 0b1111_1111); //shift and take d-th byte (8 bit)
                count[c + 1]++;
            }

            //doing count
            for (int r = 0; r < count.length - 1; r++)
                count[r + 1] += count[r];

            //making result
            for (int i = 0; i < n; i++) {
                int c = (int) ((a[i] >> 8 * d) & 0b1111_1111);
                aux[count[c]++] = a[i]; //increment count because for same value need different position in result
            }

            //copy
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }
}
