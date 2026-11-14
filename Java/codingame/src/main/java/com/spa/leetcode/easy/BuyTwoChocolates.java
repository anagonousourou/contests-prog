package com.spa.leetcode.easy;

import java.util.Arrays;

public class BuyTwoChocolates {

    // https://leetcode.com/problems/buy-two-chocolates/submissions/1124078072/

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] <= money) {
            return money - prices[0] - prices[1];
        }
        return money;
    }
}
