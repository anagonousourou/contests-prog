package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

public class SymmetricTree {

    // https://leetcode.com/problems/symmetric-tree/submissions/1135500120/

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetric(right.left, left.right) && isSymmetric(right.right, left.left);
        }
        return false;
    }
}
