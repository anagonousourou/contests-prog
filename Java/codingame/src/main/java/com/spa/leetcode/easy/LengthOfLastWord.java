package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.function.Predicate;

//https://leetcode.com/problems/length-of-last-word/submissions/1220498731/
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        var words = Arrays.stream(s.split("\\s+")).filter(Predicate.not(String::isBlank)).toList();
        return words.get(words.size() - 1).length();
    }
}
