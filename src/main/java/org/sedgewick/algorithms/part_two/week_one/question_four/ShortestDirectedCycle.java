package org.sedgewick.algorithms.part_two.week_one.question_four;

import edu.princeton.cs.algs4.Digraph;

import java.util.*;

public class ShortestDirectedCycle {

    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    Deque<Integer> cycle;

    Collection<Integer> dfs(Digraph g){
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];

        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) dfs(g, v);
        }

        return cycle;
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (int i : g.adj(v)) {
            if (!marked[i]) {
                edgeTo[i] = v;
                dfs(g, i);
            }
            else if (onStack[i]) {
                cycle = new LinkedList<>();
                for (int x = v; x != i; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(i);
//                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    /*
    time - O(V*E)
    space - O(V*E)
     */
    Collection<Integer> bfsWithSaveAllVisitedHistory(Digraph digraph){
        if (digraph == null || digraph.V() < 2) return null;

        boolean[] marked = new boolean[digraph.V()];
        Set<Integer> min = null;
        Deque<Tracer> queue = new LinkedList<>();
        for (int v = 0; v < digraph.V(); v++){
            if (!marked[v])
                queue.addLast(new Tracer(v));

            while(!queue.isEmpty()){
                Tracer tracer = queue.removeFirst();
                marked[tracer.vertex] = true;
                for (int i : digraph.adj(tracer.vertex)){
                    if (tracer.visited.contains(i)){
                        Set<Integer> cycle = cutCircle(tracer.visited, i);
                        if (min == null || min.size() > cycle.size())
                            min = cycle;
                    } else {
                        LinkedHashSet<Integer> visited = new LinkedHashSet<>(tracer.visited);
                        visited.add(i);
                        Tracer newTrace = new Tracer(i, visited);
                        queue.addLast(newTrace);
                    }
                }
            }
        }

        return min;
    }

    private Deque<Integer> getCycle(int prev, int current, int[] pathBack){
        Deque<Integer> stack = new LinkedList<>();
        while(prev != current){
            stack.addFirst(prev);
            prev = pathBack[prev];
        }
        stack.addFirst(current);
        return stack;
    }

    private Set<Integer> cutCircle(LinkedHashSet set, int i){
        LinkedHashSet<Integer> cycle = new LinkedHashSet();
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            if (i == it.next()){
                cycle.add(i);
                while (it.hasNext()){
                    cycle.add(it.next());
                }
            }
        }
        return cycle;
    }

    private class Tracer {
        int vertex;
        LinkedHashSet<Integer> visited;

        public Tracer(int vertex) {
            this.vertex = vertex;
            this.visited = new LinkedHashSet<>();
            visited.add(vertex);
        }

        public Tracer(int vertex, LinkedHashSet<Integer> visited) {
            this.vertex = vertex;
            this.visited = visited;
        }
    }
}
