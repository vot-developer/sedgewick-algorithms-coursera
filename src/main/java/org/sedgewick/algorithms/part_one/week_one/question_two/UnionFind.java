package org.sedgewick.algorithms.part_one.week_one.question_two;

public class UnionFind {
    private final int[] rootIndexes;
    private final int[] weights;
    private final int[] max;

    public UnionFind(int size) {
        rootIndexes = new int[size];
        weights = new int[size];
        max = new int[size];

        for (int i = 0; i < size; i++){
            rootIndexes[i] = i;
            max[i] = i;
        }
    }

    public void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if (rootA == rootB)
            return;

        if (weights[rootA] >= weights[rootB]){
            rootIndexes[rootB] = rootIndexes[rootA];
            weights[rootA]++;
            max[rootA] = Math.max(max[rootA], max[rootB]);
        } else {
            rootIndexes[rootA] = rootIndexes[rootB];
            weights[rootB]++;
            max[rootB] = Math.max(max[rootA], max[rootB]);
        }
    }

    public boolean connected(int a, int b) {
        if (findRoot(a) == findRoot(b))
            return true;

        return false;
    }

    public int find(int i){
        return max[findRoot(i)];
    }

    private int findRoot(int i){
        while(rootIndexes[i] != i){
            i = rootIndexes[i];
        }
        return i;
    }
}
