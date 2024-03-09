package com.spa.leetcode;

public class RingsAndRods {

    //https://leetcode.com/problems/rings-and-rods/
    public int countPoints(String rings) {
        int[] rods = new int[10];

        for (int i = 0; i < rings.length(); i += 2) {
            int rodIndex = Character.getNumericValue(rings.charAt(i + 1));
            if (rings.charAt(i) == 'R') {
                rods[rodIndex] |= 1;
            } else if (rings.charAt(i) == 'G') {
                rods[rodIndex] |= 2;
            } else {
                rods[rodIndex] |= 4;
            }
        }

        int nb = 0;
        for (int rod : rods) {
            if (rod == 7) {
                nb++;
            }
        }
        return nb;
    }
}
