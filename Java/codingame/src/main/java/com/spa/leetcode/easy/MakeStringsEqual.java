package com.spa.leetcode.easy;

import com.spa.commonfns.StringHelpers;

public class MakeStringsEqual {
    // https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/submissions/1132106764/

    public boolean makeEqual(String[] words) {
        return StringHelpers.frequencies(String.join("", words))
            .values().stream().allMatch(n -> n % words.length == 0);
    }
}
