package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

public class FindTheDifference {

    //https://leetcode.com/problems/find-the-difference/
    public char findTheDifference(String s, String t) {
        var sfreqs = StringHelpers.frequencies(s);
        var tfreqs = StringHelpers.frequencies(t);

        return tfreqs.entrySet().stream().filter(characterLongEntry -> sfreqs.getOrDefault(characterLongEntry.getKey(), 0L) < characterLongEntry.getValue())
            .findFirst().get().getKey();
    }
}
