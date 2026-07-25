package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SmallestSubsequenceOfDistinctCharacters
 */
public class SmallestSubsequenceOfDistinctCharacters {


    public String smallestSubsequence(String s) {

     Map<String, List<Integer>> charactersIndices = new HashMap<>();

     for (int i = 0; i < s.length(); i++) {
         charactersIndices.putIfAbsent(s.substring(i, i+1), new ArrayList<>()).add(i);
     }


    }
}
