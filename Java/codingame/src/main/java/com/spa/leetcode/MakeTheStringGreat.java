package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MakeTheStringGreat {

    //https://leetcode.com/problems/make-the-string-great/submissions/1226726789/?envType=daily-question&envId=2024-04-05
    public String makeGood(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Character.toLowerCase(c) == Character.toLowerCase(stack.peek()) && c != stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return new StringBuilder(stack.stream().map(String::valueOf).collect(Collectors.joining())).reverse().toString();
    }
}
