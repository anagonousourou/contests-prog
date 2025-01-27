package com.spa.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ClearDigits {

    // https://leetcode.com/problems/clear-digits/submissions/1476182555/
    public String clearDigits(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (var a : s.toCharArray()) {
            if (Character.isDigit(a)) {
                stack.removeLast();
            } else {
                stack.addLast(a);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
