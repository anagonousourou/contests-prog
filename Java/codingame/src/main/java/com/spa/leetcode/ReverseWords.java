package com.spa.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseWords {

    public String reverseWords(String s) {
        var words = Arrays.stream(s.trim().split("\\s+")).filter(Predicate.not(String::isBlank))
            .collect(Collectors.toList());
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
