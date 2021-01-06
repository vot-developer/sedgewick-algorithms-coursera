package org.sedgewick.algorithms.part_two.week_four.assigment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BoogleAdjacentsSolver {
    private final Map<BoardType, Map<Position, List<Position>>> cache = new HashMap<>();

    public Map<Position, List<Position>> getAdjacents(BoggleBoard board) {
        BoardType boardType = new BoardType(board);
        if (cache.containsKey(boardType))
            return cache.get(boardType);

        Map<Position, List<Position>> allAdjacents = new HashMap<>();
        for (int x = 0; x < board.rows(); x++)
            for (int y = 0; y < board.cols(); y++) {
                List<Position> adjacents = new ArrayList<>(8);
                int modX = x % board.rows();
                int modY = y % board.cols();

                if (modX > 0)
                    adjacents.add(new Position(x - 1, y));
                if (modX < board.rows() - 1)
                    adjacents.add(new Position(x + 1, y));
                if (modY > 0)
                    adjacents.add(new Position(x, y - 1));
                if (modY < board.cols() - 1)
                    adjacents.add(new Position(x, y + 1));

                if (modX > 0 && modY > 0)
                    adjacents.add(new Position(x - 1, y - 1));
                if (modX > 0 && modY < board.cols() - 1)
                    adjacents.add(new Position(x - 1, y + 1));
                if (modX < board.rows() - 1 && modY > 0)
                    adjacents.add(new Position(x + 1, y - 1));
                if (modX < board.rows() - 1 && modY < board.cols() - 1)
                    adjacents.add(new Position(x + 1, y + 1));

                allAdjacents.put(new Position(x, y), adjacents);
            }

        cache.put(boardType, allAdjacents);
        return allAdjacents;
    }

    private class BoardType {
        private final int cols;
        private final int rows;

        public BoardType(BoggleBoard board) {
            this.cols = board.cols();
            this.rows = board.rows();
        }

        @Override
        public boolean equals(Object b) {
            if (b == null) return false;
            if (this == b) return true;
            if (this.getClass() != b.getClass()) return false;
            BoardType boardType = (BoardType) b;
            return cols == boardType.cols && rows == boardType.rows;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cols, rows);
        }
    }
}
