package com.spa.leetcode;

public class ThreeConsecutiveOdds {

    // https://leetcode.com/problems/three-consecutive-odds/submissions/1419357186/
    public boolean threeConsecutiveOdds(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == 3) {
                return true;
            }
        }
        return false;
    }
}
