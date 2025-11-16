package com.spa.leetcode.easy;

public class AlphabetMapping {

    // https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/submissions/1619154872/
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                result.append(Character.toString((char) 'a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i+=3;
            } else {
                result.append(Character.toString((char) 'a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
                i++;
            }
        }
        return result.toString();
    }
}
