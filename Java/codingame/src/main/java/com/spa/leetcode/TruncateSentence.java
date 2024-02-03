package com.spa.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        int nbspaces = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                nbspaces++;
            }
            if (nbspaces == k) {
                return s.substring(0, i);
            }
        }
        return s;
    }

    public String truncateSentenceV2(String s, int k) {
        return Arrays.stream(s.split(" ")).limit(k).collect(Collectors.joining(" "));
    }
}
