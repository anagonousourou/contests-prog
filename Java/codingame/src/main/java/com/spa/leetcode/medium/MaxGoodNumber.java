package com.spa.leetcode.medium;

import java.util.stream.Stream;

public class MaxGoodNumber {


    // https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/submissions/1486550252/
    public int maxGoodNumber(int[] nums) {
        String a = Integer.toBinaryString(nums[0]);
        String b = Integer.toBinaryString(nums[1]);
        String c = Integer.toBinaryString(nums[2]);

        int n1 = Integer.parseInt(a + b + c, 2);
        int n2 = Integer.parseInt(a + c + b, 2);
        int n3 = Integer.parseInt(b + a + c, 2);
        int n4 = Integer.parseInt(b + c + a, 2);
        int n5 = Integer.parseInt(c + a + b, 2);
        int n6 = Integer.parseInt(c + b + a, 2);

        return Stream.of(n1, n2, n3, n4, n5, n6).max(Integer::compareTo).orElseThrow();
    }
}
