package com.spa.leetcode.easy;

import java.util.Map;

public class RomanToInteger {

    // https://leetcode.com/problems/roman-to-integer/submissions/828800530/

       public int romanToInt(String s) {
        Map<String, Integer> bases = Map.ofEntries(
                Map.entry("X", 10), Map.entry("I", 1), Map.entry("V", 5), Map.entry("L", 50), Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000),
                Map.entry("IV", 4),
                Map.entry("IX", 9),
                Map.entry("XL", 40),
                Map.entry("XC", 90), Map.entry("CD", 400), Map.entry("CM", 900));

        int total = 0;
        while(!s.isEmpty()){
            if(s.length() >= 2 && bases.containsKey(s.substring(0, 2))){
                total += bases.get(s.substring(0, 2));
                s = s.substring(2);
            }
            else{
                total += bases.get(s.substring(0,1));
                s = s.substring(1);
            }
            
        }

        return total;

    }
}
