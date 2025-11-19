package com.spa.leetcode.easy;

import java.util.BitSet;
import java.util.List;

public class FindDisappearedNumbers {

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/1834571739/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        BitSet bitSet = new BitSet(nums.length + 1);
        for (int n : nums) {
            bitSet.set(n);
        }

        bitSet.flip(1, nums.length + 1);

        return bitSet.stream().boxed().toList();
    }
}
