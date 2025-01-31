package com.spa.leetcode;

public class SignProductArray {

    // https://leetcode.com/problems/sign-of-the-product-of-an-array/submissions/1397644254/
    public int arraySign(int[] nums) {
        int nbNegatives = 0;
        int nbPositives = 0;
        int nbZeros = 0;

        for (var num : nums) {
            if (num == 0) {
                nbZeros++;
            } else if (num > 0) {
                nbPositives++;
            } else {
                nbNegatives++;
            }
        }

        if (nbZeros > 0) {
            return 0;
        } else if (nbNegatives % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
