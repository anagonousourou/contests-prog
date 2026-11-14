package com.spa.leetcode.easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {

    // https://leetcode.com/problems/valid-anagram/submissions/1121206802/

    public boolean isAnagram(String s, String t) {
        return areAnagrams(List.of(s, t));
    }

    public static boolean areAnagrams(List<String> candidates) {
        return candidates.stream().map(ValidAnagram::frequencies).collect(Collectors.toSet()).size() == 1;
    }


        public static Map<Character, Long> frequencies(String elements) {
        return elements.toLowerCase().chars().mapToObj(a -> (char) a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
