package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * IncreasingDecreasingString
 */
public class IncreasingDecreasingString {

    // https://leetcode.com/problems/increasing-decreasing-string/submissions/2080638449/
    public String sortString(String s) {
        var characterOccs = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().sorted(Comparator.comparing(Entry::getKey)).toList();

        StringBuilder result = new StringBuilder(s.length());
        while (result.length() < s.length()) {
            for (Entry<String,Long> entry : characterOccs) {
                if(entry.getValue() > 0){
                    result.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                }
            }
            for (Entry<String,Long> entry : characterOccs.reversed()) {
                if(entry.getValue() > 0){
                    result.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                }
            }
        }

        return result.toString();
    }

}
