package com.spa.leetcode;

public class CategorizeBox {


    // https://leetcode.com/problems/categorize-box-according-to-criteria/submissions/1419371298/
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = ((double) length * width * height >= Math.pow(10, 9)) || length >= 10_000 || width >= 10_000 || height >= 10_000;
        boolean heavy = (mass >= 100);
        if (heavy && bulky) {
            return "Both";
        }
        if (heavy) {
            return "Heavy";
        }
        if (bulky) {
            return "Bulky";
        }
        return "Neither";
    }
}
