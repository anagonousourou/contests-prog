package com.spa.leetcode;

import java.util.Arrays;

public class CountConsistentStrings {

    //https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
    public int countConsistentStrings(String allowed, String[] words) {
        return (int) Arrays.stream(words).filter(word -> Arrays.stream(word.split("")).allMatch(c -> allowed.contains(c))).count();
    }
}
