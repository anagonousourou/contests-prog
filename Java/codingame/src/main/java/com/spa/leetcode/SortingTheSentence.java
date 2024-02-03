package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingTheSentence {

    //https://leetcode.com/problems/sorting-the-sentence/submissions/1163865086/
    public String sortSentence(String s) {
        return Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(w -> Integer.parseInt(w.substring(w.length() - 1))))
            .map(w -> w.substring(0, w.length() - 1)).collect(Collectors.joining(" "));
    }
}
