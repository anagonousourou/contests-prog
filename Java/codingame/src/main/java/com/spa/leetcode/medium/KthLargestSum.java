package com.spa.leetcode.medium;



import com.spa.leetcode.TreeNode;

import java.util.Arrays;

public class KthLargestSum {

    // https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/submissions/1430176079/
    public long kthLargestLevelSum(TreeNode root, int k) {
        long[] sums = new long[100_000];
        sumLevel(root, 1, sums);

        Arrays.sort(sums);
        long result = sums[100_000 - k];
        return result > 0 ? result : -1;
    }

    private static void sumLevel(TreeNode root, int currentLevel, long[] sums) {
        if(root == null){
            return;
        }
        sums[currentLevel - 1] += root.val;
        sumLevel(root.left, currentLevel + 1, sums);
        sumLevel(root.right, currentLevel + 1, sums);
    }
}
