package org.sedgewick.algorithms.structures;

/**
 * Structure has following properties :
 * 1) reflexive : A is connected to A
 * 2) symmetric : if A is connected to B, then B is connected A
 * 3) transitive: if A is connected to B and B is connected to C, then A is connected to C
 * <p>
 * time - O(log n)
 * space - O(n)
 */
public class UnionFind {
    private final int[] rootIndexes;
    private final int[] weights;

    public UnionFind(int size) {
        rootIndexes = new int[size];
        weights = new int[size];

        for (int i = 0; i < size; i++) {
            rootIndexes[i] = i;
        }
    }

    public void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if (rootA == rootB)
            return;

        if (weights[rootA] >= weights[rootB]) {
            rootIndexes[rootB] = rootIndexes[rootA];
            weights[rootA]++;
        } else {
            rootIndexes[rootA] = rootIndexes[rootB];
            weights[rootB]++;
        }
    }

    public boolean isConnected(int a, int b) {
        if (findRoot(a) == findRoot(b))
            return true;

        return false;
    }

    private int findRoot(int i) {
        while (rootIndexes[i] != i) {
            //rootIndexes[i] = rootIndexes[rootIndexes[i]]; //time will be - O(log* n)
            i = rootIndexes[i];
        }
        return i;
    }
}
