package org.sedgewick.algorithms.part_two.week_one.question_three;

import edu.princeton.cs.algs4.Graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EulerСycle {

    public boolean isEulerCycle(Graph graph) {
        for (int i = 0; i < graph.V(); i++)
            if (graph.degree(i) % 2 != 0) return false;

        Set<Edge> edges = new HashSet<>();
        for (int i = 0; i < graph.V(); i++)
            for (int v : graph.adj(i))
                edges.add(new Edge(i, v));

        dfs(0, graph, edges);

        if (edges.isEmpty()) return true;
        return false;
    }

    private void dfs(int vertex, Graph graph, Set<Edge> edges) {
        for (int v: graph.adj(vertex)){
            Edge edge = new Edge(v, vertex);
            if (edges.contains(edge)){
                edges.remove(edge);
                dfs(v, graph, edges);
            }
        }
    }

    private class Edge {
        private final int a;
        private final int b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return (a == edge.a && b == edge.b) || (a == edge.b && b == edge.a);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b) + Objects.hash(b, a);
        }
    }
}
