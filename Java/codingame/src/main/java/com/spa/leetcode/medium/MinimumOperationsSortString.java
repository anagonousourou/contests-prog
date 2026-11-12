package com.spa.leetcode.medium;

import java.util.Arrays;

public class MinimumOperationsSortString {


    public int minOperations(String s) {
        if (isSorted(s)) {
            return 0;
        } else if (s.substring(1).chars().allMatch(c -> c >= s.charAt(0))) {
            return 1;
        } else if (s.substring(0, s.length() - 1).chars().allMatch(c -> c <= s.charAt(s.length() - 1))) {
            return 1;
        } else if (s.length() == 2 && !isSorted(s)) {
            return -1;
        } else if (s.substring(1).chars().allMatch(c -> c < s.charAt(0))) {
            String sortedBeginning = sortBeginning(s);
            if (!sortedBeginning.equals(s)) {
                return 1 + minOperations(sortedBeginning);
            }
            return 1 + minOperations(sortEnd(s));
        } else if (s.substring(0, s.length() - 1).chars().allMatch(c -> c > s.charAt(s.length() - 1))) {

            String sortedEnd = sortEnd(s);
            if (!sortedEnd.equals(s)) {
                return 1 + minOperations(sortedEnd);
            }
            return 1 + minOperations(sortBeginning(s));
        }

        return 2;
    }

    private boolean isSorted(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String sortBeginning(String s) {
        var parts = s.split("");
        Arrays.sort(parts, 0, parts.length - 1);
        return String.join("", parts).substring(0, parts.length - 1) + s.charAt(s.length() - 1);
    }

    private String sortEnd(String s) {
        var parts = s.split("");
        Arrays.sort(parts, 1, parts.length);
        return s.charAt(0) + String.join("", parts).substring(1);
    }

}
