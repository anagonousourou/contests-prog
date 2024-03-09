package com.spa.hackerrank;

import com.spa.commonfns.StringHelpers;

import java.util.List;

public class SherlockValidString {

    public static String isValid(String s) {
        var sFreqs = StringHelpers.frequencies(s);

        if(sFreqs.values().stream().distinct().count() == 1){
            return "YES";
        }
        List<Long> occurences = sFreqs.values().stream().distinct().toList();
        if(occurences.size() == 2 && Math.abs(occurences.get(0) - occurences.get(1)) == 1 && sFreqs.values().stream().filter(occ -> occ == Math.max(occurences.get(0) , occurences.get(1))).count() == 1){
            return "YES";
        }

        if(occurences.size() == 2 && occurences.contains(1L) && sFreqs.values().stream().filter(occ -> occ == 1L).count() == 1){
            return "YES";
        }
        return "NO";
    }
}
