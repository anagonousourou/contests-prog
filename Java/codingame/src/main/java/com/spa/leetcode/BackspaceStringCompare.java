package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class BackspaceStringCompare {

    // https://leetcode.com/problems/backspace-string-compare/submissions/1419324478/
    public boolean backspaceCompare(String s, String t) {
        return normalize(s).equals(normalize(t));
    }


    Deque<Character> normalize(String s) {
        Deque<Character> sStack = new LinkedList<>();
        for (var c : s.toCharArray()) {
            if (c == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }
        return sStack;
    }

}
