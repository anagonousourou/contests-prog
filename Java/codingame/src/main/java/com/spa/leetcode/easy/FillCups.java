package com.spa.leetcode.easy;

import java.util.Arrays;

public class FillCups {

    public int fillCups(int[] amount) {
        return fillCups(amount, 0);
    }

    // https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/submissions/1444653734/
    public int fillCups(int[] amount, int prev) {
        if (amount[0] == 0 && amount[1] == 0 && amount[2] == 0) {
            return prev;
        }

        Arrays.sort(amount);
        int nb = Math.min(amount[2], amount[1]);
        if (nb != 0) {
            amount[2] -= 1;
            amount[1] -= 1;
            return fillCups(amount, prev + 1);
        } else {
            nb = amount[2];
            amount[2] = 0;
            return fillCups(amount, prev + nb);
        }
    }
}
