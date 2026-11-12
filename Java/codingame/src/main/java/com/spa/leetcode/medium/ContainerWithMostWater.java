package com.spa.leetcode.medium;

public class ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water/submissions/2194542858/?envType=study-plan-v2&envId=leetcode-75
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            // "the shorter bar caps every container it can form, so it can be retired"
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
