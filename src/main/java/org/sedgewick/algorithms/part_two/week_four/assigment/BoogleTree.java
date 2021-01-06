package org.sedgewick.algorithms.part_two.week_four.assigment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoogleTree {
    private final int capacity;
    private final BoggleBoard board;
    private final Map<Character, List<Position>> charToV;
    private final Map<Position, List<Position>> adjacents;

    public BoogleTree(BoggleBoard board) {
        this.board = board;
        this.capacity = board.cols() * board.rows();
        this.charToV = new HashMap<>(capacity);
        this.adjacents = BoogleAdjacentsSolver.getAdjacents(board);

        for (int x = 0; x < board.rows(); x++)
            for (int y = 0; y < board.cols(); y++) {
                char c = board.getLetter(x, y);
                if (!charToV.containsKey(c))
                    charToV.put(c, new ArrayList<>());
                charToV.get(c).add(new Position(x, y));
            }
    }

    public boolean find(String s) {
        char c = s.charAt(0);
        if (charToV.get(c) == null) return false;
        return dfsSearch(charToV.get(c), s);
    }

    private boolean dfsSearch(List<Position> positions, String s) {
        if (isQNotSpecialCase(s, 0))
            return false;
        Deque<FindIndex> stack = new ArrayDeque<>(capacity);
        for (Position position : positions) {
            if (s.charAt(0) == 'Q')
                stack.addFirst(new FindIndex(position, 2));
            else
                stack.addFirst(new FindIndex(position, 1));
        }
        while (!stack.isEmpty()) {
            FindIndex fi = stack.removeFirst();
            int index = fi.index;
            if (fi.index == s.length())
                return true;
            Position p = fi.p;
            fi.marked[index(p)] = true;
            for (Position adj : adjacents.get(p)) {
                if (!fi.marked[index(adj)] && s.charAt(index) == board.getLetter(adj.x, adj.y)) {
                    if (s.charAt(index) == 'Q') {
                        if (isQNotSpecialCase(s, index))
                            return false;
                        else
                            stack.addFirst(new FindIndex(adj, index + 2, fi.marked));
                    } else
                        stack.addFirst(new FindIndex(adj, index + 1, fi.marked));
                }
            }
        }
        return false;
    }

    private boolean isQNotSpecialCase(String s, int index) {
        if (s.charAt(index) == 'Q') {
            if (index + 1 == s.length() || s.charAt(index + 1) != 'U')
                return true;
        }
        return false;
    }

    private int index(Position p) {
        return board.cols() * p.x + p.y;
    }

    private class FindIndex {
        Position p;
        int index;
        boolean[] marked = new boolean[capacity];

        public FindIndex(Position p, int index) {
            this.p = p;
            this.index = index;
        }

        public FindIndex(Position p, int index, boolean[] marked) {
            this.p = p;
            this.index = index;
            this.marked = marked.clone();
        }
    }
}
