package org.sedgewick.algorithms.part_two.week_one.question_four;

import edu.princeton.cs.algs4.Digraph;

import java.util.*;

public class ShortestDirectedCycle {

    /*
    time - O(V*E)
    space - O(V*E)
     */
    Collection<Integer> bfs(Digraph digraph){
        if (digraph == null || digraph.V() < 2) return null;

        Set<Integer> min = null;
        Deque<Tracer> queue = new LinkedList<>();
        queue.addLast(new Tracer(0));
        while(!queue.isEmpty()){
            Tracer tracer = queue.removeFirst();
            for (int i : digraph.adj(tracer.vertex)){
                if (tracer.visited.contains(i)){
                    Set<Integer> cycle = cutCircle(tracer.visited, i);
                    System.out.println("FOUND, size = " + cycle.size());
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
