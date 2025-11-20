package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {


    // https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/submissions/1643914423/?envType=daily-question&envId=2025-05-25
    public int longestPalindrome(String[] words) {
        var mappings = Arrays.stream(words)
            .filter(word -> word.charAt(0) != word.charAt(1))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Set<String> seen = new HashSet<>();
        int length = 0;
        for (var entry : mappings.entrySet()) {
            String reverseKey = new StringBuilder(entry.getKey()).reverse().toString();
            if (!seen.contains(reverseKey) && mappings.containsKey(reverseKey)) {
                length += (int) Math.min(entry.getValue(), mappings.get(reverseKey)) * 2;
                seen.add(reverseKey);
                seen.add(entry.getKey());
            }
        }

        mappings = Arrays.stream(words)
            .filter(word -> word.charAt(0) == word.charAt(1))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean rest = false;
        for (var entry : mappings.entrySet()) {
            if(entry.getValue() > 1){
                length += (int) (entry.getValue() % 2 == 0 ? entry.getValue() : entry.getValue() -1);
                rest = rest || entry.getValue() % 2 == 1;

            }else{
                rest = true;
            }
        }
        if(rest){
            length += 1;
        }


        return length * 2;
    }
}
