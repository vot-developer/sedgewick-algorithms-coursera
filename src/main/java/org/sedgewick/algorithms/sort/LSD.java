package org.sedgewick.algorithms.sort;

/**
 * Least significant digit (from last symbol to first symbol)
 */
public class LSD {

    /*
    time - O(W * n) - O(32 * n)
    space - O(R + n) - O(3 + n * int)
     */
    public static void sortByBite(int[] a){
        int R = 2; //0, 1
        int W = 32; //for integer - 32 bites
        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < W; d++){
            int[] count = new int[R + 1];
            //making index
            for (int i = 0; i < n; i++){
                int c = (a[i] >> d) & 0b1; //take d-th bite
                count[c + 1]++;
            }

            //do count
            for (int r = 0; r < count.length - 1; r++)
                count[r + 1] += count[r];

            //do swap
            for (int i = 0; i < n; i++)
                aux[count[(a[i] >> d) & 0b1]++] = a[i]; //increment count because for same value need different position in result

            //copy
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }

    /*
    time - O(W * n) - O(8 * n)
    space - O(R + n) - O(256 + n * long)
    */
    public static void sortByByte(long[] a){
        int R = 256; //8 byte in byte (2^8), we will take one last byte and sort by it
        int W = 8; //for long - 8 bytes (will do shift on 8 bites on each iteration)
        int n = a.length;
        long[] aux = new long[n];

        for (int d = 0; d < W; d++){
            int[] count = new int[R + 1];
            //making index
            for (int i = 0; i < n; i++){
                int c = (int) ((a[i] >> 8*d) & 0b1111_1111); //shift and take d-th byte (8 bit)
                count[c + 1]++;
            }

            //doing count
            for (int r = 0; r < count.length - 1; r++)
                count[r + 1] += count[r];

            //making result
            for (int i = 0; i < n; i++) {
                int c = (int) ((a[i] >> 8*d) & 0b1111_1111);
                aux[count[c]++] = a[i]; //increment count because for same value need different position in result
            }

            //copy
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }
    }
}
