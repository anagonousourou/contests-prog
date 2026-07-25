package com.spa.leetcode.easy;

/**
 * TeemoAttacking
 */
public class TeemoAttacking {

    // https://leetcode.com/problems/teemo-attacking/submissions/2080620435/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;

        for (int i = 0; i < timeSeries.length; i++) {
            if(i + 1 < timeSeries.length && timeSeries[i+1] <= timeSeries[i] + duration - 1){
                totalDuration+= timeSeries[i+1]- timeSeries[i];
            }
            else{
                totalDuration+=duration;
            }
        }
        return totalDuration;
    }
}
