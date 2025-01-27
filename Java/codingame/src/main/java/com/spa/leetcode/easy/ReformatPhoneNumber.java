package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ReformatPhoneNumber {

    // https://leetcode.com/problems/reformat-phone-number/submissions/1430219411/
    public String reformatNumber(String number) {
        number = number.replaceAll("\\s+|-", "");

        List<String> blocks = new ArrayList<>();
        while (number.length() > 4) {
            blocks.add(number.substring(0, 3));
            number = number.substring(3);
        }
        if (number.length() == 0) {
            //
        } else if (number.length() == 1) {
            //
        } else if (number.length() == 2 || number.length() == 3) {
            blocks.add(number);
        } else {
            blocks.add(number.substring(0, 2));
            blocks.add(number.substring(2));
        }

        return String.join("-", blocks);
    }
}
