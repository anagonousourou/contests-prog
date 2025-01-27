package com.spa.leetcode.easy;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ValidWord {

    // https://leetcode.com/problems/valid-word/submissions/1421803922/
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        if (!word.chars().allMatch(c -> Character.isDigit(c) || Character.isLetter(c))) {
            return false;
        }
        if (Stream.of('a', 'e', 'i', 'o', 'u').noneMatch(c -> word.toLowerCase().contains(String.valueOf(c)))) {
            return false;
        }
        return word.toLowerCase().chars().anyMatch(c -> Character.isLetter(c) && !Set.of('a', 'e', 'i', 'o', 'u').contains((char) c));
    }
}
