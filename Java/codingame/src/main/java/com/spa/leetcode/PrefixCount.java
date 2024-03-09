package com.spa.leetcode;

import java.util.Arrays;

public class PrefixCount {

    //https://leetcode.com/problems/counting-words-with-a-given-prefix/
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
    }
}
