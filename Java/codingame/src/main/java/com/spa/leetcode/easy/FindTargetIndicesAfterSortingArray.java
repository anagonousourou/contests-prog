package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindTargetIndicesAfterSortingArray {

    // https://leetcode.com/problems/find-target-indices-after-sorting-array/submissions/2098732779/
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        return IntStream.range(0, nums.length).filter(i -> nums[i] == target).boxed().toList();
    }
}
