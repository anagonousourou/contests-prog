package com.spa.leetcode.medium;

import com.spa.commonfns.StringHelpers;

public class MinimumStepsToMakeTwoStringsAnagram {

    //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/submissions/1145161015/
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
