package com.spa.leetcode;

import java.util.Arrays;
import java.util.List;

public class StringMatchingArray {

    // https://leetcode.com/problems/string-matching-in-an-array/submissions/1397463806/
    public List<String> stringMatching(String[] words) {
        return Arrays.stream(words).filter(word -> Arrays.stream(words).anyMatch(w -> !w.equals(word) && w.contains(word)))
            .toList();
    }
}
