package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAStringIii {

    // https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/1168846634/

    public String reverseWords(String s) {
        return Arrays.stream(s.split("\\s+"))
            .map(word -> new StringBuilder().append(word).reverse().toString())
            .collect(Collectors.joining(" "));
    }
}
