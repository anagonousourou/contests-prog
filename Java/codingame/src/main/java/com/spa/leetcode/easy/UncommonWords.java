package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UncommonWords {

    // https://leetcode.com/problems/uncommon-words-from-two-sentences/submissions/1549601851/
    public String[] uncommonFromSentences(String s1, String s2) {
        var words1 = Arrays.stream(s1.split("\s+")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var words2 = Arrays.stream(s2.split("\s+")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> uncommonWords = new ArrayList<>();
        for (var entry : words1.entrySet()) {
            if (entry.getValue() == 1 && !words2.containsKey(entry.getKey())) {
                uncommonWords.add(entry.getKey());
            }
        }

        for (var entry : words2.entrySet()) {
            if (entry.getValue() == 1 && !words1.containsKey(entry.getKey())) {
                uncommonWords.add(entry.getKey());
            }
        }

        return uncommonWords.toArray(new String[0]);
    }
}
