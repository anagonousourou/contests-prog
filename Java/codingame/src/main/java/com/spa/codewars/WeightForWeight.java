package com.spa.codewars;


import com.spa.commonfns.StringHelpers;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WeightForWeight {

    record Weight(String weight, int key) {
    }

    /**
     * https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java
     *
     * @param strng
     * @return
     */
    public static String orderWeight(String strng) {
        return StringHelpers.reSeq(Pattern.compile("\\d+"), strng).stream().map(str -> new Weight(str, str.chars().map(Character::getNumericValue).sum()))
            .sorted(Comparator.comparing(Weight::key).thenComparing(Weight::weight)).map(Weight::weight).collect(Collectors.joining(" "));
    }
}
