package com.spa.leetcode;

import java.util.Arrays;

public class NumDistinctIntegers {

    // https://leetcode.com/problems/number-of-different-integers-in-a-string/submissions/1397659284/
    public int numDifferentIntegers(String word) {
        word = word.replaceAll("\\p{Alpha}", " ");
        var parts = word.split("\\s+");
        return (int) Arrays.stream(parts).filter(p -> !p.isBlank()).map(p -> removeLeadingZeros(p.trim())).distinct().count();
    }

    private static String removeLeadingZeros(String w){
        for (int j = 0; j < w.length(); j++) {
            if(w.charAt(j) != '0'){
                return w.substring(j);
            }
        }
        return "0";
    }
}
