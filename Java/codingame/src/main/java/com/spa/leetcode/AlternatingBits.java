package com.spa.leetcode;

public class AlternatingBits {

    //https://leetcode.com/problems/binary-number-with-alternating-bits/description/
    public boolean hasAlternatingBits(int n) {
        String rep = Integer.toBinaryString(n);

        for (int i = 0; i < rep.length() - 1; i++) {
            if(rep.charAt(i) == rep.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }
}
