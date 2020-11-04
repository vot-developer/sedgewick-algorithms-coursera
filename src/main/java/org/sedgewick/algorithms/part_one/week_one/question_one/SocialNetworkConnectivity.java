package org.sedgewick.algorithms.part_one.week_one.question_one;

public class SocialNetworkConnectivity {
    private final int[] parents;
    private final int[] sizes;

    public SocialNetworkConnectivity(int size) {
        this.parents = new int[size];
        this.sizes = new int[size];

        for (int i = 0; i < size; i++){
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if (rootA == rootB)
            return; //already united

        if (sizes[rootA] >= sizes[rootB]){
            parents[rootB] = parents[rootA];
            sizes[rootA] += sizes[rootB];
        } else {
            parents[rootA] = parents[rootB];
            sizes[rootB] += sizes[rootA];
        }
    }

    public boolean isConnected(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    public int getSize(int i) {
        return sizes[findRoot(i)];
    }

    private int findRoot(int i){
        while(parents[i] != i){
            i = parents[i];
        }
        return i;
    }

}
