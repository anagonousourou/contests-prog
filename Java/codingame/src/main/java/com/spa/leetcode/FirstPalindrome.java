package com.spa.leetcode;

import java.util.Arrays;

public class FirstPalindrome {

    //https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
            .findFirst().orElse("");
    }
}
