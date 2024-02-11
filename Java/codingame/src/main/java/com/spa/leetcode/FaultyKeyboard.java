package com.spa.leetcode;

public class FaultyKeyboard {

    //https://leetcode.com/problems/faulty-keyboard/
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
