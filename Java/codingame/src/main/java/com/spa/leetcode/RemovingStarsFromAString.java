package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class RemovingStarsFromAString {

    //https://leetcode.com/problems/removing-stars-from-a-string
    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peekLast() == '*' && s.charAt(i) != '*') {
                stack.pollLast();
            } else {
                stack.addLast(s.charAt(i));
            }
        }

        return new StringBuilder(stack.stream().map(String::valueOf).collect(Collectors.joining())).reverse().toString();
    }
}
