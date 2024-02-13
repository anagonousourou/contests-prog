package com.spa.leetcode;

public class NumberOfArithmeticTriplets {


    //https://leetcode.com/problems/number-of-arithmetic-triplets/description/
    public int arithmeticTriplets(int[] nums, int diff) {
        int nbTriplets = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int nb = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nb == 0 && nums[j] - nums[i] == diff) {
                    nb++;
                } else if (nb == 1 && nums[j] - nums[i] == 2 * diff) {
                    nbTriplets++;
                    break;
                }
            }
        }
        return nbTriplets;
    }

}
