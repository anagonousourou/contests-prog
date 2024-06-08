package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReplaceWords {

    // https://leetcode.com/problems/replace-words/submissions/1280291539/
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        return Arrays.stream(words).map(word -> dictionary.stream()
            .filter(word::startsWith)
            .min(Comparator.comparingInt(String::length))
            .orElse(word)).collect(Collectors.joining(" "));
    }
}
