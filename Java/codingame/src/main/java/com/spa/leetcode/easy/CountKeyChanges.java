package com.spa.leetcode.easy;

public class CountKeyChanges {

    // https://leetcode.com/problems/number-of-changing-keys/submissions/1545024943/
    public int countKeyChanges(String s) {
        int count = 0;
        String sLower = s.toLowerCase();
        for (int i = 1; i < s.length(); i++) {
            if(sLower.charAt(i) != sLower.charAt(i-1)){
                count++;
            }
        }
        return count;
    }
}
