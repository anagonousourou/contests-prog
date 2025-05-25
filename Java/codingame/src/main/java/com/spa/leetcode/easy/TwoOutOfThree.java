package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {


    // https://leetcode.com/problems/two-out-of-three/submissions/1623883109/
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> result = new HashSet<>();

        for (int value : nums1) {
            for (int i : nums2) {
                for (int j : nums3) {
                    if (value == i) {
                        result.add(value);
                    }

                    if (i == j) {
                        result.add(i);
                    }

                    if (value == j) {
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
