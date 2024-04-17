package com.spa.leetcode;

import java.util.Arrays;

public class CountPrefixes {

    //https://leetcode.com/problems/count-prefixes-of-a-given-string/submissions/1195508819/
    public int countPrefixes(String[] words, String s) {
        return (int) Arrays.stream(words).filter(s::startsWith).count();
    }
}
