package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCommonWordsWithOneOccurrence {

    //https://leetcode.com/problems/count-common-words-with-one-occurrence/
    public int countWords(String[] words1, String[] words2) {
        var freqs1 = Arrays.stream(words1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        var freqs2 = Arrays.stream(words2).filter(freqs1::containsKey).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return (int) freqs2.values().stream().filter(occurrence -> occurrence == 1).count();
    }
}
