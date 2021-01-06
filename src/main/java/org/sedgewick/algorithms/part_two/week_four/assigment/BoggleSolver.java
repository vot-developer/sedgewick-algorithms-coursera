package org.sedgewick.algorithms.part_two.week_four.assigment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BoggleSolver {
    private final BoogleAdjacentsSolver boogleAdjacentsSolver;
    private final RTrie trie;

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        this.boogleAdjacentsSolver = new BoogleAdjacentsSolver();
        this.trie = new RTrie(dictionary);
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        RTrie result = new RTrie();
        for (int x = 0; x < board.rows(); x++)
            for (int y = 0; y < board.cols(); y++)
                dfs(x, y, board, boogleAdjacentsSolver.getAdjacents(board), result);
        return result;
    }

    private void dfs(int x, int y, BoggleBoard board, Map<Position, List<Position>> adjacents, RTrie result) {
        RTrieIterator rTrieIterator = new RTrieIterator(trie.getRoot());
        if (!rTrieIterator.hasNext(board.getLetter(x, y))) return;
        Deque<Step> stack = new ArrayDeque<>();
        stack.addFirst(new Step(x, y, rTrieIterator));

        while (!stack.isEmpty()) {
            Step step = stack.removeFirst();
            Position p = step.p;
            RTrieIterator rTrie = step.rTrieIterator;
            step.track.add(p); // marked = true;
            char c = board.getLetter(p.x(), p.y());
            if (!rTrie.hasNext(c)) continue;

            if (c == 'Q') {
                rTrie.next(c);
                if (rTrie.hasNext('U'))
                    rTrie.next('U');
            } else
                rTrie.next(c);

            if (rTrie.isString())
                saveWord(step.track, board, result);

            for (Position ajd : adjacents.get(p)) {
                if (rTrie.hasNext(board.getLetter(ajd.x(), ajd.y())) && !step.track.contains(ajd))
                    stack.addFirst(new Step(ajd, step.track, new RTrieIterator(rTrie)));
            }
        }
    }

    private void saveWord(List<Position> positions, BoggleBoard board, RTrie result) {
        StringBuilder sb = new StringBuilder();
        for (Position p : positions) {
            char c = board.getLetter(p.x(), p.y());
            sb.append(c);
            if (c == 'Q')
                sb.append('U');
        }
        if (trie.contains(sb.toString()))
            result.add(sb.toString());
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (!trie.contains(word))
            return 0;
        switch (word.length()) {
            case 0:
            case 1:
            case 2:  return 0;
            case 3:
            case 4:  return 1;
            case 5:  return 2;
            case 6:  return 3;
            case 7:  return 5;
            default: return 11;
        }
    }

    private class Step {
        Position p;
        List<Position> track;
        RTrieIterator rTrieIterator;

        public Step(int x, int y, RTrieIterator rTrieIterator) {
            this.p = new Position(x, y);
            this.track = new ArrayList<>();
            this.rTrieIterator = rTrieIterator;
        }

        public Step(Position p, List<Position> track, RTrieIterator rTrieIterator) {
            this.p = p;
            if (track != null)
                this.track = new ArrayList<>(track);
            this.rTrieIterator = rTrieIterator;
        }
    }
}
