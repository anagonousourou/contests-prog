package com.spa.leetcode.easy;

public class FinalPrices {

    // https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/1639275514/
    public int[] finalPrices(int[] prices) {
        int[] result = prices.clone();

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j] <= prices[i]){
                    result[i] -= prices[j];
                    break;
                }
            }
        }
        return result;
    }
}
