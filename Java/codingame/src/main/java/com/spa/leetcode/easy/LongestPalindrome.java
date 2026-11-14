package com.spa.leetcode.easy;

import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {

    // https://leetcode.com/problems/longest-palindrome/submissions/832060794/

    public int longestPalindrome(String s) {
        var lettersCount = s.chars().<String>mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long l = 0;
        int rest = 0;
        for (var letterCount : lettersCount.entrySet()) {
            if (letterCount.getValue() % 2 == 0) {
                l += letterCount.getValue();
            } else {
                l += letterCount.getValue() - 1;
                rest++;
            }
        }
        if (rest > 0) {
            return (int) l + 1;
        }
        return (int) l;
    }
}
