package org.sedgewick.algorithms.search.graph;

import java.util.*;

public class TarjanStronglyConnectedComponents {

    public static int[] findSCC(Map<Integer, Set<Integer>> digraph){
        Integer[] rank = new Integer[digraph.size()];
        for (int i = 0; i < digraph.size(); i++)
            dfs(i, new HashSet<>(), digraph, rank);
        return Arrays.stream(rank).mapToInt(i -> i).toArray();
    }

    private static int dfs(int v, Set<Integer> stack, Map<Integer, Set<Integer>> digraph, Integer[] rank){
        if (rank[v] != null)
            return rank[v];

        rank[v] = v;
        stack.add(v);
        int min = v;
        for (int w : digraph.get(v)){
            int res = dfs(w, stack, digraph, rank);
            if (stack.contains(w))
                min = Math.min(min, res);
        }
        if (rank[v] == min){ //finish SCC and flush it from stack
            Iterator<Integer> it = stack.iterator();
            while (it.hasNext()){
                int k = it.next();
                if (rank[k] == rank[v])
                    it.remove();
            }
        } else
            rank[v] = min;
        return min;
    }
}
