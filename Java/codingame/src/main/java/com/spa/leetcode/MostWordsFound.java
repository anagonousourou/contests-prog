package com.spa.leetcode;

import java.util.Arrays;

public class MostWordsFound {

    //https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences).mapToInt(s -> (int) s.chars().mapToObj(c -> (char) c).filter(c -> c == ' ').count())
            .max().orElse(0) + 1;
    }
}
