package org.sedgewick.algorithms.part_two.week_one.assigment_one;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class SAP {
    private final Digraph g;

    private class Result {
        int ancestor;
        int length;

        public Result(int ancestor, int length) {
            this.ancestor = ancestor;
            this.length = length;
        }
    }

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        validateArgument(G);
        this.g = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        validateArguments(v, w);
        return doSap(v, w).length;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        validateArguments(v, w);
        return doSap(v, w).ancestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        validateArguments(v, w);
        Set<Integer> vset = new HashSet<>();
        v.iterator().forEachRemaining(vset::add);
        Set<Integer> wset = new HashSet<>();
        w.iterator().forEachRemaining(wset::add);
        return doSap(vset, wset).length;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        validateArguments(v, w);
        Set<Integer> vset = new HashSet<>();
        v.iterator().forEachRemaining(vset::add);
        Set<Integer> wset = new HashSet<>();
        w.iterator().forEachRemaining(wset::add);
        return doSap(vset, wset).ancestor;
    }

    private Result doSap(int v, int w) {
        return doSap(new HashSet<>(Arrays.asList(v)), new HashSet<>(Arrays.asList(w)));
    }

    private Result doSap(Set<Integer> v, Set<Integer> w) {
        Map<Integer, Integer> vvisited = new HashMap<>();
        Map<Integer, Integer> wvisited = new HashMap<>();
        Queue<Integer> vqueue = new ArrayDeque<>();
        Queue<Integer> wqueue = new ArrayDeque<>();
        v.iterator().forEachRemaining(i -> {
            vqueue.add(i);
            vvisited.put(i, null);
        });
        w.iterator().forEachRemaining(i -> {
            wqueue.add(i);
            wvisited.put(i, null);
        });
        Set<Integer> ancestors = new HashSet<>();
        while ((!vqueue.isEmpty() || !wqueue.isEmpty())) {
            if (!vqueue.isEmpty()) {
                Integer vStep = vqueue.remove();
                checkIntersection(vStep, wvisited, ancestors);
                doBFSStep(vStep, vqueue, vvisited);
            }
            if (!wqueue.isEmpty()) {
                Integer wStep = wqueue.remove();
                checkIntersection(wStep, vvisited, ancestors);
                doBFSStep(wStep, wqueue, wvisited);
            }
        }

        return calculateResult(ancestors, v, vvisited, w, wvisited);
    }

    private void checkIntersection(Integer v, Map<Integer, Integer> oppVisited, Set<Integer> ancestors) {
        if (oppVisited.containsKey(v))
            ancestors.add(v);
    }

    private Result calculateResult(Set<Integer> ancestors,
                                   Set<Integer> v, Map<Integer, Integer> vvisited,
                                   Set<Integer> w, Map<Integer, Integer> wvisited) {
        if (ancestors.isEmpty()) return new Result(-1, -1);

        int minLength = Integer.MAX_VALUE;
        int minAncestor = -1, length;

        for (Integer ancestor : ancestors) {
            length = 0;
            length += calculatePart(ancestor, v, vvisited);
            length += calculatePart(ancestor, w, wvisited);
            if (length < minLength) {
                minLength = length;
                minAncestor = ancestor;
            }
        }
        return new Result(minAncestor, minLength);
    }

    private int calculatePart(int ancestor, Set<Integer> v, Map<Integer, Integer> visited) {
        int length = 0;
        Integer i = ancestor;
        while (!v.contains(i) && i != null) {
            i = visited.get(i);
            length++;
        }
        return length;
    }

    private void doBFSStep(Integer v, Queue<Integer> queue, Map<Integer, Integer> visited) {
        for (int i : g.adj(v)) {
            if (!visited.containsKey(i)) {
                visited.put(i, v);
                queue.add(i);
            }
        }
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }

    private void validateArgument(Digraph digraph) {
        if (digraph == null)
            throw new IllegalArgumentException("Null argument passed.");
    }

    private void validateArguments(int a, int b) {
        validateArgument(a);
        validateArgument(b);
    }

    private void validateArgument(int arg) {
        if (arg < 0 || arg >= g.V())
            throw new IllegalArgumentException("Vertex id out of range.");
    }

    private void validateArguments(Iterable<Integer> a, Iterable<Integer> b) {
        validateArgument(a);
        validateArgument(b);
    }

    private void validateArgument(Iterable<Integer> arg) {
        if (arg == null)
            throw new IllegalArgumentException("Null argument passed.");

        for (Integer item : arg) {
            if (item == null)
                throw new IllegalArgumentException("Iterable has 'null' item.");
            validateArgument(item);
        }
    }

}
