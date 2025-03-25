package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class KeyboardRow {

    // https://leetcode.com/problems/keyboard-row/submissions/1553827035/
    private static final Set<Set<String>> rows = Set.of(
        Arrays.stream("qwertyuiop".split("")).collect(Collectors.toSet()),
        Arrays.stream("asdfghjkl".split("")).collect(Collectors.toSet()),
        Arrays.stream("zxcvbnm".split("")).collect(Collectors.toSet())
        );
    public String[] findWords(String[] words) {
       return  Arrays.stream(words).filter(word ->
            rows.stream().anyMatch(row -> row.containsAll(Arrays.stream(word.toLowerCase().split("")).collect(Collectors.toSet()) )))
            .toArray(String[]::new);
    }
}
