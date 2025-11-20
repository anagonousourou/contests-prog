package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class FindDisappearedNumbers {

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/1639289452/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] present = new boolean[nums.length];

        for (int num : nums) {
            present[num - 1] = true;
        }
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < present.length; i++) {
            if (!present[i]) {
                missing.add(i + 1);
            }
        }
        return missing;
        }
    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/1834571739/
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        BitSet bitSet = new BitSet(nums.length + 1);
        for (int n : nums) {
            bitSet.set(n);
        }

        bitSet.flip(1, nums.length + 1);

        return bitSet.stream().boxed().toList();
    }
}
