package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class CanBeTypedWords {

    //https://leetcode.com/problems/maximum-number-of-words-you-can-type/submissions/1799268244/
    public int canBeTypedWords(String text, String brokenLetters) {
        List<String> letters =  Arrays.stream(brokenLetters.split("")).filter(s -> !s.isBlank()).toList();
         return (int) Arrays.stream(text.split("\\s+")).filter(word -> letters.isEmpty() || letters.stream().noneMatch(word::contains))
             .count();
    }
}
