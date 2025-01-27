package com.spa.leetcode;

public class ToHex {

    //https://leetcode.com/problems/convert-a-number-to-hexadecimal/
    public String toHex(int num) {
        StringBuilder result = new StringBuilder();

        while (num  > 0){
            int rem = num % 16;
            result.insert(0, map(rem));
            num = num / 16;
        }
        return result.toString();
    }

    private static String map(int i){
        if(i < 10){
            return String.valueOf(i);
        }
        return String.valueOf(Character.valueOf((char) ('a' + (i - 10))));
    }
}
