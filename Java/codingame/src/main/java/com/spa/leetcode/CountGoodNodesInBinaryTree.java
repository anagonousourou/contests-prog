package com.spa.leetcode;

public class CountGoodNodesInBinaryTree {

    //https://leetcode.com/problems/count-good-nodes-in-binary-tree/
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int maximum) {
        if (root == null) {
            return 0;
        }
        if (root.val >= maximum) {
            return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
        } else {
            return goodNodes(root.left, maximum) + goodNodes(root.right, maximum);
        }
    }

}
