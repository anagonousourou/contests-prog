package com.spa.leetcode.easy;

import java.util.List;
import java.util.stream.IntStream;

public class FindWordsContainingCharacter {


    //https://leetcode.com/problems/find-words-containing-character/submissions/1643306914/
    public List<Integer> findWordsContaining(String[] words, char x) {
        String needle = "" + x;
        return IntStream.range(0, words.length).filter(i -> words[i].contains(needle)).boxed().toList();
    }
}
