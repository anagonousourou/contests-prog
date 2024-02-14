package com.spa.leetcode;

public class EvaluateBooleanBinaryTree {

    //https://leetcode.com/problems/evaluate-boolean-binary-tree/
    public boolean evaluateTree(TreeNode root) {
        if (root.right == null && root.left == null) {
            return root.val == 1;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        if (root.val == 3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }
}
