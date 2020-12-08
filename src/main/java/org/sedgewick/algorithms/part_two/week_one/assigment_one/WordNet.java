package org.sedgewick.algorithms.part_two.week_one.assigment_one;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordNet {
    private final Map<String, Set<Integer>> nounsToIds;
    private final String[] nounsByIds;
    private final Digraph digraph;
    private final SAP sap;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        validateArgument(synsets);
        validateArgument(hypernyms);

        this.nounsToIds = new HashMap<>();
        this.nounsByIds = nounsInitialization(synsets);
        this.digraph = new Digraph(this.nounsByIds.length);
        hypernymsInitialization(hypernyms);
        validateDigraph(digraph);
        sap = new SAP(digraph);
    }

    private void hypernymsInitialization(String hypernymsFileName) {
        String[] lines = new In(hypernymsFileName).readAllLines();
        for (String line : lines) {
            String[] items = line.split(",");
            int synsetId = Integer.parseInt(items[0]);
            for (int i = 1; i < items.length; i++) {
                digraph.addEdge(synsetId, Integer.parseInt(items[i]));
            }
        }
    }

    private String[] nounsInitialization(String sunsetsFileNmae) {
        String[] lines = new In(sunsetsFileNmae).readAllLines();
        String[] nouns = new String[lines.length];
        for (String line : lines) {
            String[] items = line.split(",");
            int synsetId = Integer.parseInt(items[0]);
            nouns[synsetId] = items[1];
            String[] words = items[1].split("\\s");
            for (String word : words) {
                if (!this.nounsToIds.containsKey(word))
                    this.nounsToIds.put(word, new HashSet<>());
                this.nounsToIds.get(word).add(synsetId);
            }
        }
        return nouns;
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nounsToIds.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String noun) {
        validateArgument(noun);
        return nounsToIds.containsKey(noun);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        validateArgument(nounA, nounB);
        return sap.length(nounsToIds.get(nounA), nounsToIds.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        validateArgument(nounA, nounB);
        int sapId = sap.ancestor(nounsToIds.get(nounA), nounsToIds.get(nounB));
        return nounsByIds[sapId];
    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet wordNet = new WordNet(args[0], args[1]);
        StdOut.println(wordNet.sap("Colin_luther_Powell", "Lee_Harvey_Oswald"));
    }

    private void validateArgument(String nounA, String nounB) {
        validateArgument(nounA);
        validateArgument(nounB);
        if (!nounsToIds.containsKey(nounA) || !nounsToIds.containsKey(nounB))
            throw new IllegalArgumentException("Unknown nouns");
    }

    private void validateArgument(String string) {
        if (string == null)
            throw new IllegalArgumentException("Argument can't be null");
    }

    private static void validateDigraph(Digraph digraph) {
        DirectedCycle cycle = new DirectedCycle(digraph);
        if (cycle.hasCycle())
            throw new IllegalArgumentException("Digraph isn't a DAG");

        int count = 0;
        for (int v = 0; v < digraph.V(); v++)
            if (digraph.outdegree(v) == 0 && ++count > 1)
                throw new IllegalArgumentException("Digraph hasn't single root.");
    }
}
