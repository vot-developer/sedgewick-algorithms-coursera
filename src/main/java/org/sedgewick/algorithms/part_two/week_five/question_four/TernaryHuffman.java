package org.sedgewick.algorithms.part_two.week_five.question_four;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TernaryHuffman {
    private final static int R = 27; //alphabet + ' '
    private final static int SHIFT = 96;

    public Map<Character, String> generateCodewords(String s) {
        int[] frequencies = countFrequencies(s);
        Node root = buildTrie(s, frequencies);
        Map map = generateMap(root);
        return map;
    }

    private int[] countFrequencies(String s){
        int[] frequencies = new int[R];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                frequencies[0]++;
            else
                frequencies[s.charAt(i) - SHIFT]++;
        }
        return frequencies;
    }

    private Node buildTrie(String s, int[] frequencies){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(' ', frequencies[0], null, null, null));
        for (int i = 1; i < R; i++)
            pq.add(new Node((char) (i + SHIFT), frequencies[i], null, null, null));

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node middle = pq.poll();
            Node right = pq.poll();

            pq.offer(new Node('0', left.freq + middle.freq + right.freq, left, middle, right));
        }
        return pq.poll();
    }

    private Map<Character, String> generateMap(Node root){
        Map<Character, String> map = new HashMap<>();
        Queue<Element> queue = new ArrayDeque<>();
        queue.add(new Element(root, ""));
        while (!queue.isEmpty()){
            Element element = queue.poll();
            Node node = element.node;

            if (node.isLeaf()) {
                map.put(node.c, element.s);
                continue;
            }

            if (node.left != null)
                queue.add(new Element(node.left, element.s + "0"));

            if (node.middle != null)
                queue.add(new Element(node.middle, element.s + "1"));

            if (node.right != null)
                queue.add(new Element(node.right, element.s + "2"));
        }
        return map;
    }

    private class Element{
        Node node;
        String s;

        public Element(Node node, String s) {
            this.node = node;
            this.s = s;
        }
    }
}
