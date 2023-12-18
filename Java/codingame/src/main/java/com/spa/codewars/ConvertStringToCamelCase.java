package com.spa.codewars;

import com.spa.commonfns.StringHelpers;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConvertStringToCamelCase {

    static String toCamelCase(String s) {
        if (s.isBlank()) {
            return "";
        }
        List<String> words = StringHelpers.reSeq(Pattern.compile("\\p{Alpha}+"), s);
        return words.get(0) + words.stream().skip(1).map(str -> str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase()).collect(Collectors.joining());
    }
}
