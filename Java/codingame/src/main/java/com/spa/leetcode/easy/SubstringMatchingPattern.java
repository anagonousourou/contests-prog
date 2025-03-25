package com.spa.leetcode.easy;



import java.util.regex.Pattern;

public class SubstringMatchingPattern {

    // https://leetcode.com/problems/substring-matching-pattern/submissions/1557206964/
    public boolean hasMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p.replace("*", ".*"));
        return pattern.asPredicate().test(s);
    }
}
