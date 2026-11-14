package com.spa.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    // https://leetcode.com/problems/min-cost-climbing-stairs/submissions/2195869517/?envType=study-plan-v2&envId=leetcode-75
    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, cost.length, new HashMap<>());
    }

    public int minCostClimbingStairs(int[] cost, int step, Map<Integer, Integer> costCache) {

        if (step <= 1) {
            return 0;
        }
        if (!costCache.containsKey(step - 1)) {
            costCache.put(step - 1, minCostClimbingStairs(cost, step - 1, costCache));
        }
        int costStep1 = costCache.get(step - 1);
        if (!costCache.containsKey(step - 2)) {
            costCache.put(step - 2, minCostClimbingStairs(cost, step - 2, costCache));
        }
        int costStep2 = costCache.get(step - 2);
        return Math.min(costStep1 + cost[step - 1], costStep2 + cost[step - 2]);
    }
}
