package com.spa.leetcode;

public class CountAsterisks {

    //https://leetcode.com/problems/count-asterisks/
    public int countAsterisks(String s) {
        boolean insidePair = false;

        int nbAsterisks = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!insidePair && s.charAt(i) == '*') {
                nbAsterisks++;
            } else if (!insidePair && s.charAt(i) == '|') {
                insidePair = true;
            } else if (insidePair && s.charAt(i) == '|') {
                insidePair = false;
            }
        }
        return nbAsterisks;
    }
}
