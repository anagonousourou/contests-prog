package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

public class RemoveLetterToEqualizeFrequency {

    //TOBECONTINUED (incorrect)
    public boolean equalFrequency(String word) {

        //every letter has the same frequence and one of them has a occurence == 1
        //there are two frequences values


        long[] frequenciesValues = StringHelpers.frequencies(word).values().stream().mapToLong(Long::longValue).distinct().toArray();
        return frequenciesValues.length == 2 && Math.abs(frequenciesValues[0] - frequenciesValues[1]) == 1;
    }
}
