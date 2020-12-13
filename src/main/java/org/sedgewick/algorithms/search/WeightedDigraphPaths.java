package org.sedgewick.algorithms.search;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WeightedDigraphPaths {
    private final EdgeWeightedDigraph digraph;
    private final Set<DirectedEdge>[] edgesTo;
    private final int s;

    /*
    time - O(2^E)
    space - O(E * V)
     */
    public WeightedDigraphPaths(EdgeWeightedDigraph digraph, int s) {
        this.digraph = digraph;
        this.edgesTo = new HashSet[digraph.V()];
        this.s = s;

        for (int i = 0; i < digraph.V(); i++)
            for (edu.princeton.cs.algs4.DirectedEdge e : digraph.adj(i))
                visit(new DirectedEdge(e));
    }

    public List<edu.princeton.cs.algs4.DirectedEdge> findShortest(int v) {
        List<Path> paths = findAllPaths(v);
        if (paths.size() == 0) return null;
        Path shortestPath = paths.get(0);
        return shortestPath.stack.stream().map(e -> e.toAlgsEdge()).collect(Collectors.toList());
    }

    private void visit(DirectedEdge e) {
        int w = e.to();
        if (edgesTo[w] == null)
            edgesTo[w] = new HashSet<>();
        if (!edgesTo[w].contains(e))
            edgesTo[w].add(e);
    }

    public List<Path> findAllPaths(int v) {
        Set<Path> paths = new HashSet<>();
        for (DirectedEdge e : edgesTo[v]) {
            Path p = new Path(e);
            paths.add(p);
            collectPaths(e.from(), p, paths);
        }
        return new ArrayList(new TreeSet<>(paths));
    }

    private void collectPaths(int v, Path originalPath, Set<Path> paths) {
        if (v == s) return;
        paths.remove(originalPath);
        for (DirectedEdge e : edgesTo[v]) {
            Path path = originalPath.fork();
            path.addEdge(e);
            paths.add(path);
            collectPaths(e.from(), path, paths);
        }
    }

    public class Path implements Comparable<Path> {
        double weight;
        LinkedList<DirectedEdge> stack;

        public Path(DirectedEdge e) {
            this.stack = new LinkedList<>();
            addEdge(e);
        }

        public Path(double weight, LinkedList<DirectedEdge> stack) {
            this.weight = weight;
            this.stack = stack;
        }

        public void addEdge(DirectedEdge e) {
            this.weight += e.weight();
            this.stack.addFirst(e);
        }

        public Path fork() {
            Path clone = new Path(weight, new LinkedList<>(stack));
            return clone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path path = (Path) o;
            return Double.compare(path.weight, weight) == 0 && stack.equals(path.stack);
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, stack);
        }

        @Override
        public int compareTo(Path o) {
            if (weight < o.weight)
                return -1;
            if (weight > o.weight)
                return 1;
            if (stack.size() < o.stack.size())
                return -1;
            if (stack.size() > o.stack.size())
                return 1;

            Iterator<DirectedEdge> itO = o.stack.iterator();
            for (Iterator<DirectedEdge> it = stack.iterator(); it.hasNext(); ) {
                DirectedEdge eO = itO.next();
                DirectedEdge e = it.next();
                if (e.compareTo(eO) != 0) return e.compareTo(eO);
            }
            return 0;
        }
    }
}
