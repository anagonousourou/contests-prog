package com.spa.leetcode.easy;

public class ReverseStringII {

    // https://leetcode.com/problems/reverse-string-ii/submissions/1459078962/
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < s.length()) {

            int limit = Math.min(i + k - 1, s.length() - 1);
            for (int j = limit; j >= i; j--) {
                result.append(s.charAt(j));
            }

            if (limit != s.length() - 1) {
                result.append(s, limit + 1, Math.min(s.length(), limit + 1 + k));
            }
            i = Math.min(s.length(), limit + 1 + k);
        }

        return result.toString();
    }
}
