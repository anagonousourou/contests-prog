package com.spa.leetcode.medium;

public class MinimumCostToAcquireRequiredItems {


    // https://leetcode.com/problems/minimum-cost-to-acquire-required-items/submissions/2193983489/?envType=daily-question&envId=2026-11-11
    // The idea is basically to try to see how much discount buying the third type brings compared to individually buying the type 1 and 2. individually
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (costBoth > cost1 + cost2) {
            return (long) cost2 * need2 + (long) cost1 * need1;
        } else if (costBoth <= cost1 && costBoth <= cost2) {
            return (long) costBoth * Math.max(need1, need2);
        } else if (costBoth <= cost1 + cost2) {
            return (long) costBoth * Math.min(need1, need2) + ((long) Math.abs(need2 - need1) * (need1 > need2 ? Math.min(cost1, costBoth) : Math.min(cost2, costBoth)));
        }
        return costBoth + Math.max(need1, need2);
    }
}
