package com.spa.leetcode.easy;

public class NumberAfterDoubleReversal {

    //https://leetcode.com/problems/a-number-after-a-double-reversal/submissions/1175102620/
    public boolean isSameAfterReversals(int num) {
        int reversed1 = Integer.parseInt(new StringBuilder().append(num).reverse().toString());
        return Integer.parseInt(new StringBuilder().append(reversed1).reverse().toString()) == num;
    }
}
