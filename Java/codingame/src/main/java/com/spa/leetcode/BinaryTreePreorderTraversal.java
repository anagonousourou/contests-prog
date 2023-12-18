package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {


    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> content = new ArrayList<>();
        preorderTraversal(root, content);
        return content;
    }

    private void preorderTraversal(TreeNode root, List<Integer> content) {
        if (root == null) {
            return;
        }

        content.add(root.val);
        preorderTraversal(root.left, content);
        preorderTraversal(root.right, content);
    }
}
