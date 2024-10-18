package com.spa.leetcode.easy;

public class MinChanges {

    // https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/submissions/1424227115/
    public int minChanges(int n, int k) {
        if((n & k) != k){
            return -1;
        }
        return Integer.bitCount(n) - Integer.bitCount(k);
    }
}
