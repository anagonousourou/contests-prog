package com.spa.leetcode;

import java.util.List;
import java.util.stream.IntStream;

public class FindWordsContainingCharacter {


    //https://leetcode.com/problems/find-words-containing-character/
    public List<Integer> findWordsContaining(String[] words, char x) {
        String needle = "" + x;
        return IntStream.range(0, words.length).filter(i -> words[i].contains(needle)).boxed().toList();
    }
}
