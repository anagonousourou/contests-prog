package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveAnagrams {

    // https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/submissions/1424133568/
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        var current = normalize(words[0]);
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!current.equals(normalize(words[i]))) {
                result.add(words[i]);
                current = normalize(words[i]);
            }
        }
        return result;
    }

    private static Map<Integer, Long> normalize(String word) {
        return word.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
