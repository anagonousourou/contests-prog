package com.spa.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveOuterParentheses {

    // https://leetcode.com/problems/remove-outermost-parentheses/submissions/1624208313/
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }else if(s.charAt(i) == '('){
                stack.add(s.charAt(i));
                result.append(s.charAt(i));
            }else if(s.charAt(i) == ')' && stack.size() == 1){
                stack.pop();
            }
            else if(s.charAt(i) == ')' && stack.size() != 1){
                stack.pop();
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
