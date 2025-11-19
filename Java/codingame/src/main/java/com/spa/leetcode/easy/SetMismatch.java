package com.spa.leetcode.easy;

public class SetMismatch {

    // https://leetcode.com/problems/set-mismatch/submissions/1834557004/?envType=problem-list-v2&envId=dsa-linear-shoal-array-ii
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                res[0] = i;
            }
            if (map.getOrDefault(i, 0) == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}
