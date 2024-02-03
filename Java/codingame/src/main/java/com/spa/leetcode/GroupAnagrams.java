package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).collect(Collectors.groupingBy(StringHelpers::frequencies, Collectors.toList()))
            .values().stream().toList();
    }
}
