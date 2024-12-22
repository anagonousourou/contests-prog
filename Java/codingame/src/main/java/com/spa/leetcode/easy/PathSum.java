package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

public class PathSum {


    // https://leetcode.com/problems/path-sum/submissions/1439861126/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root, targetSum, 0);
    }

    private boolean sum(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        } else if (targetSum == currentSum + root.val && root.left == null && root.right == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return false;
        } else {
            return sum(root.left, targetSum, currentSum + root.val) || sum(root.right, targetSum, currentSum + root.val);
        }
    }
}
