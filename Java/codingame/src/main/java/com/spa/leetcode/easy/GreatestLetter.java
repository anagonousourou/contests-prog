package com.spa.leetcode.easy;

import java.util.Arrays;

public class GreatestLetter {


    // https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/submissions/1530354020/
    public String greatestLetter(String s) {
        return Arrays.stream(s.split("")).filter(c -> Character.isUpperCase(c.charAt(0)) && s.contains(c.toLowerCase()))
            .max(String::compareTo).orElse("");
    }
}
