package com.spa.leetcode;

public class BalancedStringsSplit {

    //https://leetcode.com/problems/split-a-string-in-balanced-strings/
    public int balancedStringSplit(String s) {
        int nb = 0;
        int nbL = 0;
        int nbR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                nbL++;
            }

            if (s.charAt(i) == 'R') {
                nbR++;
            }
            if (nbL == nbR && nbL != 0) {
                nb++;
                nbL = 0;
                nbR = 0;
            }
        }
        return nb;
    }
}
