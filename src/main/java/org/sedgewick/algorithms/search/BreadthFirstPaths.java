package org.sedgewick.algorithms.search;

import org.sedgewick.algorithms.structures.Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {
    private final Graph graph;
    private final int s;
    private final boolean[] marked;
    private final Integer[] pathTo;

    public BreadthFirstPaths(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
        this.marked = new boolean[graph.V()];
        this.pathTo = new Integer[graph.V()];
        marked[s] = true;
        bfs(s);
    }

    public boolean hasToPath(int v){
        return marked[v];
    }

    public Deque<Integer> pathTo(int v){
        Deque<Integer> path = new LinkedList<>();
        while(v != s){
            path.addFirst(pathTo[v]); //stack
            v = pathTo[v];
        }
        return path;
    }

    private void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            Integer v = queue.remove();
            for (int i : graph.adj(v)){
                if (!marked[i]) {
                    marked[i] = true;
                    pathTo[i] = v;
                    queue.add(i);
                }
            }
        }
    }
}
