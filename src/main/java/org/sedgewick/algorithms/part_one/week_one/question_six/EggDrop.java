package org.sedgewick.algorithms.part_one.week_one.question_six;

public class EggDrop {
    /**
     * time O(K*logN), space - K*N.
     *
     * @param K - count of eggs
     * @param N - count of floor
     * @return count of movement to find T (the highest floor where eggs don't break)
     */
    public int drop(int K, int N) {
        int[][] map = new int[N + 1][K + 1];//map[m][k] - maximum number of floor which we can check
        int m = 0;
        while (map[m][K] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                map[m][k] = 1 + map[m - 1][k] + map[m - 1][k - 1];//1 - this attempt, (m-1, k) - don't break case, (m-1, k) - break case.
                //after move (m-1) and 1 attempt, you could check two interval - lower and higher. lower - (m-1, k-1) - break case, higher - (m-1, k).
            }
        }
        return m;
    }
}
