package com.spa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumNumberStringPairs {

    //https://leetcode.com/problems/find-maximum-number-of-string-pairs/
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> wordSet = new HashSet<>();
        int nb = 0;
        for (String word : words) {
            if (wordSet.contains(new StringBuilder(word).reverse().toString())) {
                nb++;
            } else {
                wordSet.add(word);
            }
        }
        return nb;
    }
}
