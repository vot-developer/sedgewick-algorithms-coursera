package org.sedgewick.algorithms.part_two.week_two.question_five;

import org.sedgewick.algorithms.structures.DirectedEdge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Path implements Comparable<Path> {
    double weight;
    LinkedList<DirectedEdge> edges;

    public Path(DirectedEdge e) {
        this.edges = new LinkedList<>();
        addEdge(e);
    }

    public Path(double weight, LinkedList<DirectedEdge> edges) {
        this.weight = weight;
        this.edges = edges;
    }

    public void addEdge(DirectedEdge e) {
        this.weight += e.weight();
        this.edges.addLast(e);
    }

    public Path fork() {
        Path clone = new Path(weight, new LinkedList<>(edges));
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Path)) return false;
        Path path = (Path) o;
        return Double.compare(path.weight, weight) == 0 && edges.equals(path.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, edges);
    }

    @Override
    public int compareTo(Path o) {
        if (weight < o.weight)
            return -1;
        if (weight > o.weight)
            return 1;
        if (edges.size() < o.edges.size())
            return -1;
        if (edges.size() > o.edges.size())
            return 1;

        Iterator<DirectedEdge> itO = o.edges.iterator();
        for (Iterator<DirectedEdge> it = edges.iterator(); it.hasNext(); ) {
            DirectedEdge eO = itO.next();
            DirectedEdge e = it.next();
            if (e.compareTo(eO) != 0) return e.compareTo(eO);
        }
        return 0;
    }
}