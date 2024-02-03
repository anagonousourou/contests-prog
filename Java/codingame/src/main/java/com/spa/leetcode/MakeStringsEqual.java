package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

public class MakeStringsEqual {
    public boolean makeEqual(String[] words) {
        return StringHelpers.frequencies(String.join("", words))
            .values().stream().allMatch(n -> n % words.length == 0);
    }
}
