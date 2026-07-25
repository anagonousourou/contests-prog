package com.spa.leetcode.easy;

import java.util.Arrays;

public class MinimumCandyCost {


    // https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/submissions/2019338651/?envType=daily-question&envId=2026-06-01
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int count = 0;
        int total = 0;
        for (int i = cost.length - 1; i >= 0 ; i--) {
            if(count < 2){
                total+=cost[i];
                count++;
            }else {
                count = 0;
            }
        }
        return total;
    }
}
