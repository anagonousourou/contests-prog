package com.spa.codewars;

import com.spa.commonfns.StringHelpers;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MostFrequentlyUsedWordsInText {

    public static List<String> top3(String s) {
        return StringHelpers.frequencies(
                StringHelpers.reSeq(Pattern.compile("\\p{Alpha}+'+\\p{Alpha}+|'*\\p{Alpha}+'*"), s.toLowerCase())
            )
            .entrySet().stream().sorted(Comparator.comparingLong(e -> -e.getValue())).limit(3).map(Map.Entry::getKey)
            .toList();

    }
}
