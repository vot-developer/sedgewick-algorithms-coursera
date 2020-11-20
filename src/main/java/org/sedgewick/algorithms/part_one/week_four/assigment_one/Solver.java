package org.sedgewick.algorithms.part_one.week_four.assigment_one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.ResizingArrayStack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Solver {
    private boolean isSolvable;
    private Iterable<Board> solution;
    private int moves = -1;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null)
            throw new IllegalArgumentException("Argument is null");

        solve(initial);
    }

    private void solve(Board initial) {
        MinPQ<Node> pqueue = new MinPQ<>(Comparator.comparingInt(node -> node.priority));
        MinPQ<Node> twinPqueue = new MinPQ<>(Comparator.comparingInt(node -> node.priority));
        Node result = null;
        pqueue.insert(new Node(null, initial));
        twinPqueue.insert(new Node(null, initial.twin()));

        while (!pqueue.isEmpty() || !twinPqueue.isEmpty()) {
            Node node = pqueue.delMin();
            if (node.board.isGoal()) {
                result = node;
                isSolvable = true;
                break;
            }
            for (Board neighbor : node.board.neighbors())
                if (node.prev == null || !node.prev.board.equals(neighbor))
                    pqueue.insert(new Node(node, neighbor));

            Node nodeTwin = twinPqueue.delMin();
            if (nodeTwin.board.isGoal()) {
                isSolvable = false;
                break;
            }
            for (Board neighbor : nodeTwin.board.neighbors())
                if (nodeTwin.prev == null || !nodeTwin.prev.board.equals(neighbor))
                    twinPqueue.insert(new Node(nodeTwin, neighbor));
        }

        if (isSolvable) {
            ResizingArrayStack<Board> solution = new ResizingArrayStack<>();
            this.moves = result.move;
            while (result != null) {
                solution.push(result.board);
                result = result.prev;
            }
            this.solution = solution;
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solution;
    }

    // test client (see below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    private class Node {
        Node prev;
        Board board;
        int move;
        int priority;

        public Node(Node prev, Board board) {
            this.prev = prev;
            this.board = board;
            if (prev != null) this.move = prev.move + 1;
            this.priority = board.manhattan() + move;
        }
    }
}