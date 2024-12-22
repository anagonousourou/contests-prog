package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayZero {

    // https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/submissions/1476071581/
    public int minimumOperations(int[] nums) {
        int nbOperations = 0;
        while (true) {
            var optMin = Arrays.stream(nums).filter(n -> n != 0)
                .min();

            if (optMin.isPresent()) {
                int min = optMin.getAsInt();
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        nums[i] -= min;
                    }
                }
                nbOperations++;
            } else {
                break;
            }
        }
        return nbOperations;

    }

    /**
     * It works because every non-zero numbers who share the same value can be reduced to zero in one operation
     * The other non-zero number would have new values still greater than zero
     * (since it is the minimum value that is taken) AND distinct (since x != y -> x - a != y - a)
     * And we repeat the process, so at the end the number of operations is needed is the same
     * as the number of distinct non-zero values in the array initially
     * @param nums
     * @return
     */
    // https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/submissions/1476081342/
    // my rewrite of the alternative solution
    public int minimumOperations2(int[] nums) {
        return (int) Arrays.stream(nums).filter(n -> n != 0).distinct().count();
    }

    // alternative solution taken from leetcode solutions
    public int minimumOperationsFaster(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i > 0) set.add(i);
        }
        return set.size();
    }

}
