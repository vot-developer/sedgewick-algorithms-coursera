package org.sedgewick.algorithms.part_two.week_five.question_four;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TernaryHuffmanTest {

    @Test
    void test() {
        TernaryHuffman ternaryHuffman = new TernaryHuffman();
        Map<Character, String> codewords = ternaryHuffman.generateCodewords("generalize the huffman algorithm to codewords over the ternary alphabet instead of the binary alphabet");
        assertEquals("21", codewords.get(' ')); //freq 14
        assertEquals("12", codewords.get('e')); //freq 12
        assertEquals("10", codewords.get('a')); //freq 10
        assertEquals("02", codewords.get('t')); //freq 9
        assertEquals("00", codewords.get('r')); //freq 7
        assertEquals("110210", codewords.get('j')); //freq 0
    }
}