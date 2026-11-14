package com.spa.leetcode.easy;

import com.spa.commonfns.StringHelpers;

public class FindTheDifference {

    //https://leetcode.com/problems/find-the-difference/submissions/1135703677/
    public char findTheDifference(String s, String t) {
        var sfreqs = StringHelpers.frequencies(s);
        var tfreqs = StringHelpers.frequencies(t);

        return tfreqs.entrySet().stream().filter(characterLongEntry -> sfreqs.getOrDefault(characterLongEntry.getKey(), 0L) < characterLongEntry.getValue())
            .findFirst().get().getKey();
    }
}
