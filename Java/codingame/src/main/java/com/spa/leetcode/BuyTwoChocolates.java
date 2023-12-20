package com.spa.leetcode;

import java.util.Arrays;

public class BuyTwoChocolates {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] <= money) {
            return money - prices[0] - prices[1];
        }
        return money;
    }
}
