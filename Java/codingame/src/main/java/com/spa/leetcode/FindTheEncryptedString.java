package com.spa.leetcode;

public class FindTheEncryptedString {

    // https://leetcode.com/problems/find-the-encrypted-string/submissions/1418864248/
    public String getEncryptedString(String s, int k) {
        var input = s.toCharArray();
        var output = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            output[i] = input[(i + k) % s.length()];
        }
        return new String(output);
    }
}
