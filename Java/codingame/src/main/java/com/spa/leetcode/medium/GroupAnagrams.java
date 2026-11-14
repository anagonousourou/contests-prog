package com.spa.leetcode.medium;

import com.spa.commonfns.StringHelpers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // https://leetcode.com/problems/group-anagrams/submissions/1167601569/

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs).collect(Collectors.groupingBy(StringHelpers::frequencies, Collectors.toList()))
            .values().stream().toList();
    }
}
