package com.spa.leetcode;

import java.util.List;

public class CountPairs {

    //https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/submissions/1173161375/
    public int countPairs(List<Integer> nums, int target) {
        int nb = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    nb++;
                }
            }
        }
        return nb;
    }
}
