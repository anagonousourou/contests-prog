package com.spa.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class RemoveDuplicates {

    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/1478542719/
    public String removeDuplicates(String s) {
        Deque<String> stack = new LinkedList<>();
        for (var c : s.split("")) {
            if (c.equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        Iterable<String> iterable = stack::descendingIterator;
        return StreamSupport.stream(iterable.spliterator(), false)
            .collect(Collectors.joining());

        //return String.join("", stack.reversed());
    }
}
