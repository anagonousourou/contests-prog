package com.spa.leetcode;

public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        return mergeAlternately(word1, word2, "");
    }

    public String mergeAlternately(String word1, String word2, String result) {
        if (word2.isEmpty()) {
            return result + word1;
        }
        if (word1.isEmpty()) {
            return result + word2;
        }
        return mergeAlternately(word1.substring(1), word2.substring(1),
            result + word1.charAt(0) + word2.charAt(0));

    }
}
