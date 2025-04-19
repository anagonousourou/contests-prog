package com.spa.leetcode.easy;

public class MaxContainersShip {

    // https://leetcode.com/problems/maximum-containers-on-a-ship/submissions/1586763629/
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(maxWeight/w, n * n);
    }
}
