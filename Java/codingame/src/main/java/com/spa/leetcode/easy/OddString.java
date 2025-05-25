package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddString {

    // https://leetcode.com/problems/odd-string-difference/submissions/1585773825/
    public String oddString(String[] words) {
        return Arrays.stream(words)
            .collect(Collectors.groupingBy(OddString::difference))
            .entrySet().stream().filter(e -> e.getValue().size() == 1).findFirst().orElseThrow().getValue().get(0);
    }

    private static String difference(String word) {
        List<String> result = new ArrayList<>(word.length());
        for (int i = 0; i < word.length() - 1; i++) {
            result.add(String.valueOf(word.charAt(i + 1) - word.charAt(i)));
        }
        return String.join("-", result);
    }
}
