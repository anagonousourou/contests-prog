package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

public class MinimumDepthOfBinaryTree {

    // https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/1135554299/

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
