package com.spa.leetcode.easy;

import java.util.Arrays;

public class BitwiseORHasTrailingZeros {

    // https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/submissions/1195064487/

    //https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros
    public boolean hasTrailingZeros(int[] nums) {
        return Arrays.stream(nums).filter(n -> n % 2 == 0).count() >= 2;
    }
}
