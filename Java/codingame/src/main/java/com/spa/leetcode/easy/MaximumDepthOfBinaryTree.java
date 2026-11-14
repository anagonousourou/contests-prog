package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

public class MaximumDepthOfBinaryTree {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1123324890/

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
