package com.spa.leetcode.easy;

public class MirrorDistance {

    // https://leetcode.com/problems/mirror-distance-of-an-integer/submissions/1981574963/?envType=daily-question&envId=2026-04-18
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n){
        return Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
    }
}
