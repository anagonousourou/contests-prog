package com.spa.leetcode.easy;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsDistinct {

    // https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/submissions/1585627512/
    public int minimumOperationsV1(int[] nums) {
        Set<Integer> occs = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (occs.contains(nums[i])) {
                return (i + 1) % 3 == 0 ? (i + 1) / 3 : ((i + 1) / 3) + 1;
            }
            occs.add(nums[i]);
        }
        return 0;
    }

    // https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/submissions/1585629142/
    public int minimumOperations(int[] nums) {
        BitSet occs = new BitSet(100);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (occs.get(nums[i])) {
                return (i + 1) % 3 == 0 ? (i + 1) / 3 : ((i + 1) / 3) + 1;
            }
            occs.set(nums[i]);
        }
        return 0;
    }
}
