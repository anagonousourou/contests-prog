package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumDeletions {

    // https://leetcode.com/problems/removing-minimum-and-maximum-from-array/submissions/2125111217/?envType=daily-question&envId=2026-08-30
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int max = Arrays.stream(nums).max().orElseThrow();
        int min = Arrays.stream(nums).min().orElseThrow();

        int maxIndex = IntStream.range(0, nums.length).filter(i -> nums[i] == max).findAny().orElseThrow();
        int minIndex = IntStream.range(0, nums.length).filter(i -> nums[i] == min).findAny().orElseThrow();

        //both from the front
        int bothFromTheFront = Math.max(maxIndex + 1, minIndex + 1);
        //both from the back
        int bothFromTheBack = Math.max(nums.length - maxIndex, nums.length - minIndex);
        // max from the front and min from the back
        int tmp3 = maxIndex + 1 + nums.length - minIndex;
        //min from the front and max from the back
        int tmp4 = nums.length - maxIndex + minIndex + 1;

        return IntStream.of(bothFromTheFront, bothFromTheBack, tmp3, tmp4).min().orElseThrow();
    }
}
