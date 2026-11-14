package com.spa.leetcode.easy;

public class FaultyKeyboard {

    //https://leetcode.com/problems/faulty-keyboard/submissions/1171384710/
    public String finalString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                stringBuilder.reverse();
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
