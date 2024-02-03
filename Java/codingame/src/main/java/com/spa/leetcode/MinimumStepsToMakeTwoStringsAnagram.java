package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

public class MinimumStepsToMakeTwoStringsAnagram {

    //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
    public int minSteps(String s, String t) {
        var sFreqs = StringHelpers.frequencies(s);
        var tFreqs = StringHelpers.frequencies(t);

        int c = 0;
        for (var eltCount : sFreqs.entrySet()) {
            if (tFreqs.containsKey(eltCount.getKey())) {
                if (eltCount.getValue() <= tFreqs.get(eltCount.getKey())) {
                    c += eltCount.getValue();
                }
                if (eltCount.getValue() > tFreqs.get(eltCount.getKey())) {
                    c += tFreqs.get(eltCount.getKey());
                }
            }
        }
        return s.length() - c;
    }
}
