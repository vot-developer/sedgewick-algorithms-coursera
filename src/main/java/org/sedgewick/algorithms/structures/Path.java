package org.sedgewick.algorithms.structures;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Path implements Comparable<Path> {
    public double weight;
    public Set<DirectedEdge> edges;

    public Path(DirectedEdge e) {
        this.edges = new LinkedHashSet<>();
        addEdge(e);
    }

    public Path(double weight, Set<DirectedEdge> edges) {
        this.weight = weight;
        this.edges = edges;
    }

    public void addEdge(DirectedEdge e) {
        this.weight += e.weight();
        this.edges.add(e);
    }

    public Path fork() {
        Path clone = new Path(weight, new LinkedHashSet<>(edges));
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
            DirectedEdge e = it.next();
            DirectedEdge eO = itO.next();
            if (e.to() > eO.to())
                return 1;
            if (e.to() < eO.to())
                return -1;
        }

        return 0;
    }
}
