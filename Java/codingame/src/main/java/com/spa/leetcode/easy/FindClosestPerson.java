package com.spa.leetcode.easy;

public class FindClosestPerson {

    // https://leetcode.com/problems/find-closest-person/submissions/2124891895/
    public int findClosest(int x, int y, int z) {
        if(Math.abs(x - z) < Math.abs(y -z)){
            return 1;
        } else if (Math.abs(x - z) > Math.abs(y -z)) {
            return 2;
        }
        else {
            return 0;
        }
    }
}
