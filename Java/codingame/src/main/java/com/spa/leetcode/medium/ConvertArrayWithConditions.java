package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArrayWithConditions {

    // https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/submissions/1134433528/

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        while (true) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 || (!row.isEmpty() && nums[i] == row.get(row.size() - 1))) {
                    continue;
                } else {
                    row.add(nums[i]);
                    nums[i] = 0;
                }
            }
            if (row.isEmpty()) {
                break;
            } else {
                result.add(row);
            }
        }
        return result;
    }
}
