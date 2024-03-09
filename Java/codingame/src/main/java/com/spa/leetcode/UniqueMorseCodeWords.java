package com.spa.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UniqueMorseCodeWords {


    private static final String[] MORSES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        return (int) Arrays.stream(words).map(this::transform).distinct().count();
    }

    private String transform(String word) {
        return word.chars().mapToObj(c -> MORSES[c - 'a']).collect(Collectors.joining());
    }
}
