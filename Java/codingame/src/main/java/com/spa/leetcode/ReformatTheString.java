package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ReformatTheString {

    // https://leetcode.com/problems/reformat-the-string/submissions/1389550053/
    public String reformatV1(String s) {
        Deque<Character> digits = new LinkedList<>();
        Deque<Character> letters = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }
        StringBuilder result = new StringBuilder();
        int whoStart = digits.size() > letters.size() ? 1 : 0;
        int lastOne = -1;
        while (!digits.isEmpty() || !letters.isEmpty()) {
            if (whoStart == 1) {
                whoStart = -1;
                result.append(digits.pop());
                lastOne = 1;
            } else if (whoStart == 0) {
                whoStart = -1;
                result.append(letters.pop());
                lastOne = 0;
            } else {
                if (lastOne == 1 && letters.isEmpty()) {
                    return "";
                } else if (lastOne == 0 && digits.isEmpty()) {
                    return "";
                } else if (lastOne == 1) {
                    result.append(letters.pop());
                    lastOne = 0;
                } else {
                    result.append(digits.pop());
                    lastOne = 1;
                }
            }

        }
        return result.toString();
    }


    // https://leetcode.com/problems/reformat-the-string/submissions/1389557623/
    public String reformat(String s) {
        Deque<Character> digits = new LinkedList<>();
        Deque<Character> letters = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }

        if (Math.abs(digits.size() - letters.size()) > 1) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int whoStart = digits.size() > letters.size() ? 1 : 0;
        while (!digits.isEmpty() || !letters.isEmpty()) {
            if (whoStart == 1) {
                result.append(digits.pop());
                whoStart = 0;
            } else {
                result.append(letters.pop());
                whoStart = 1;
            }
        }
        return result.toString();
    }


}
