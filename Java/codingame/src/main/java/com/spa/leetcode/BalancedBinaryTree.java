package com.spa.leetcode;

public class BalancedBinaryTree {

    //https://leetcode.com/problems/balanced-binary-tree/submissions/
    public boolean isBalanced(TreeNode current) {
        if (current == null) {
            return true;
        }
        if (current.left == null && current.right == null) {
            current.val = 0;
            return true;
        }
        if (current.left == null) {
            boolean rightBalanced = isBalanced(current.right);
            current.val = current.right.val + 1;
            if (rightBalanced) {
                return current.right.val < 2;
            }
            return false;
        }
        if (current.right == null) {
            boolean leftBalanced = isBalanced(current.left);
            current.val = current.left.val + 1;
            if (leftBalanced) {
                return current.left.val < 2;
            }
            return false;
        }

        boolean leftBalanced = isBalanced(current.left);
        boolean rightBalanced = isBalanced(current.right);
        if (leftBalanced && rightBalanced) {
            current.val = Math.max(current.left.val, current.right.val) + 1;
            return Math.abs(current.left.val - current.right.val) < 2;
        }
        return false;
    }
}
