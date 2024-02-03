package com.spa.leetcode;

import java.util.List;
import java.util.stream.Collectors;

public class IsAcronym {

    //https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words
    public boolean isAcronym(List<String> words, String s) {
        return words.stream().map(word -> word.substring(0, 1)).collect(Collectors.joining()).equals(s);
    }
}
