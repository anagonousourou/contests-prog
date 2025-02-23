package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveDigitFromNumber {

    // https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/submissions/1549647727/
    public String removeDigit(String number, char digit) {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                options.add(number.substring(0, i) + number.substring(i + 1));
            }
        }
        //the sort of String works because they have the same width
        Collections.sort(options);
        return options.get(options.size() - 1);
    }
}
