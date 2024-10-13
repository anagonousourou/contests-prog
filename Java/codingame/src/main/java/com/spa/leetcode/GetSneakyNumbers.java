package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetSneakyNumbers {

    // https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/submissions/1419332201/
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> sneakers = new ArrayList<>(2);
        int[] counter = new int[nums.length - 2];

        for (var num : nums) {
            counter[num] += 1;
            if (counter[num] == 2) {
                sneakers.add(num);
            }
        }
        return sneakers.stream().mapToInt(Integer::intValue).toArray();
    }
}
