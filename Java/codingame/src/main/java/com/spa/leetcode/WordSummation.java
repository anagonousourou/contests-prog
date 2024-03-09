package com.spa.leetcode;

import java.util.stream.Collectors;

public class WordSummation {

    //https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return wordValue(firstWord) + wordValue(secondWord) == wordValue(targetWord);
    }

    private static int wordValue(String word) {
        return Integer.parseInt(word.chars().map(c -> c - 'a').mapToObj(String::valueOf).collect(Collectors.joining()));
    }
}
