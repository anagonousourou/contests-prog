package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MakeStringsEqual {
    public boolean makeEqual(String[] words) {
        return StringHelpers.frequencies(String.join("", words))
            .values().stream().allMatch(n -> n % words.length == 0);
    }
}
