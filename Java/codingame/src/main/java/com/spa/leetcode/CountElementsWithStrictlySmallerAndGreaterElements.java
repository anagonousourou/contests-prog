package com.spa.leetcode;

import java.util.Arrays;

public class CountElementsWithStrictlySmallerAndGreaterElements {

    // https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/submissions/1197028354/
    public int countElements(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        return (int) Arrays.stream(nums).filter(num -> min < num && num < max).count();
    }
}
