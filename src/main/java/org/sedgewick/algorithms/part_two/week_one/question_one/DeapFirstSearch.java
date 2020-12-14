package org.sedgewick.algorithms.part_two.week_one.question_one;

import edu.princeton.cs.algs4.Graph;
import java.util.Deque;
import java.util.LinkedList;

public class DeapFirstSearch {
    private final Graph graph;
    private final boolean[] marked;
    private final int[] pathTo;
    private final int s;

    public DeapFirstSearch(Graph graph, int s) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];
        this.pathTo = new int[graph.V()];
        this.s = s;
        marked[s] = true;
        dfs();
    }

    private void dfs(){
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(s);
        while (!stack.isEmpty()){
            Integer v = stack.removeFirst();
            for (int i : graph.adj(v)){
                if (!marked[i]){
                    pathTo[i] = v;
                    marked[i] = true;
                    stack.addFirst(i);
                }
            }
        }
    }

    public boolean hasToPath(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        Deque<Integer> stack = new LinkedList<>();
        while (v != s){
            stack.addFirst(pathTo[v]);
            v = pathTo[v];
        }
        return stack;
    }
}
