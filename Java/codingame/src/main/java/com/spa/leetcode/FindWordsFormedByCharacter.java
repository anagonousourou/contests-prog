package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.Arrays;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class FindWordsFormedByCharacter {

    public int countCharacters(String[] words, String chars) {
        var charsFrequencies = StringHelpers.frequencies(chars);
        return Arrays.stream(words).map(StringHelpers::frequencies).filter(wordCharsFrequencies ->
                wordCharsFrequencies.keySet().stream().allMatch(character ->
                    charsFrequencies.getOrDefault(character, 0L) >= wordCharsFrequencies.get(character)))
            .mapToInt(wordCharsFrequencies -> wordCharsFrequencies.values().stream().mapToInt(l -> (int) l.longValue()).sum()).sum();

    }


}
