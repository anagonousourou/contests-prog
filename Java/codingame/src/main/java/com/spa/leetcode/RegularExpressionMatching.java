package com.spa.leetcode;

import java.util.regex.Pattern;

public class RegularExpressionMatching {

    //https://leetcode.com/problems/regular-expression-matching/submissions/1195035595/
    public boolean isMatch(String s, String p) {
        p = p.replace("***", "*");
        return Pattern.compile(p).asMatchPredicate().test(s);
    }
}
