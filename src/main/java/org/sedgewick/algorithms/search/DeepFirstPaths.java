package org.sedgewick.algorithms.search;

import org.sedgewick.algorithms.structures.Graph;

import java.util.*;

public class DeepFirstPaths {
    private final Graph graph;
    private final int s;
    private final boolean[] marked;
    private final Integer[] pathTo;

    public DeepFirstPaths(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
        this.marked = new boolean[graph.V()];
        this.pathTo = new Integer[graph.V()];
        marked[s] = true;
        dfs(s);
    }

    public boolean hasToPath(int v){
        return marked[v];
    }

    Queue<Integer> pathTo(int v){
        Deque<Integer> path = new LinkedList<>();
        while(v != s){
            path.push(pathTo[v]);
            v = pathTo[v];
        }
        return path;
    }

    private void dfs(int v){
        for (int i : graph.adj(v)){
            if (!marked[i]) {
                marked[i] = true;
                pathTo[i] = v;
                dfs(i);
            }
        }
    }
}
