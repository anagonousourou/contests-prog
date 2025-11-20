package com.spa.leetcode.easy;

public class ContainsPattern {

    // https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/submissions/1619082021/
    public boolean containsPattern(int[] arr, int m, int k) {
        //check every index as beginning of a pattern
        for (int i = 0; i < arr.length; i++) {
            boolean patternOk = true;
            // for every index of the pattern
            for (int l = 0; l < m; l++) {
                // we check that it repeats k times
                for (int j = 1; j < k; j++) {
                    // if pattern does not repeat, or we reach the end of the array before
                    if ((i + l + m * j) >= arr.length || arr[i + l] != arr[i + l + m * j]) {
                        // then the pattern [i, i + m] does not repeat k times. We
                        // can then check [i + 1, i + m + 1]
                        patternOk = false;
                        break;
                    }
                }
            }
            if (patternOk) {
                return true;
            }
        }

        return false;
    }
}
