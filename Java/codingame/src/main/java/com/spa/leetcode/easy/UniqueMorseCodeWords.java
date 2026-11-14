package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UniqueMorseCodeWords {

    // https://leetcode.com/problems/unique-morse-code-words/submissions/1172453815/


    private static final String[] MORSES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        return (int) Arrays.stream(words).map(this::transform).distinct().count();
    }

    private String transform(String word) {
        return word.chars().mapToObj(c -> MORSES[c - 'a']).collect(Collectors.joining());
    }
}
