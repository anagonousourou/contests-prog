package com.spa.leetcode;

public class DelayedArrivalTime {

    // https://leetcode.com/problems/calculate-delayed-arrival-time/submissions/1419305431/
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
