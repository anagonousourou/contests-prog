package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheOriginalTypedStringI {

    // https://leetcode.com/problems/find-the-original-typed-string-i/submissions/2142824948/
    public int possibleStringCount(String word) {

        int count = 1;
        char currentChar = word.charAt(0);
        int currentCount = 1;
        for (int i = 1; i < word.length(); i++) {
            if(currentChar != word.charAt(i)){
                count += (currentCount - 1);
                currentCount = 1;
                currentChar = word.charAt(i);
            }else{
                currentCount++;
            }
        }
        count += (currentCount - 1);


        return count;
    }
}
