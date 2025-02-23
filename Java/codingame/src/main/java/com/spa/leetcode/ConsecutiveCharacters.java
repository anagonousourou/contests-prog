package com.spa.leetcode;

public class ConsecutiveCharacters {

    // https://leetcode.com/problems/consecutive-characters/submissions/1397474055/
    public int maxPower(String s) {

        int max = 1;
        char current = ' ';
        int currentLength = 1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == current){
                currentLength++;
                max = Math.max(max, currentLength);
            }else{
                current = s.charAt(i);
                currentLength = 1;
            }
        }
        return max;
    }
}
