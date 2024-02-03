package com.spa.leetcode;

public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return deleteRoot(root);
        } else {
            deleteNodeInternal(root, key);
        }
        return root;
    }

    private TreeNode deleteRoot(TreeNode root) {

        var right = root.right;
        var left = root.left;
        if (right == null) {
            return root.left;
        }
        if (left == null) {
            return right;
        }
        var current = right;
        while (current.left != null) {
            current = current.left;
        }
        current.left = left;
        return right;
    }

    private void deleteNodeInternal(TreeNode root, int key) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null && root.left.val == key) {
            var leftLeft = root.left.left;
            root.left = root.left.right;

            var current = root;
            while (current.left != null) {
                current = current.left;
            }
            current.left = leftLeft;
            return;
        }

        if (root.right != null && root.right.val == key) {
            var leftLeft = root.right.left;
            root.right = root.right.right;

            var current = root.right;
            if (current == null) {
                root.right = leftLeft;
            } else {
                while (current.left != null) {
                    current = current.left;
                }
                current.left = leftLeft;
            }

            return;
        }

        if (root.right != null && root.val < key) {
            deleteNodeInternal(root.right, key);
        }
        if (root.left != null && root.val > key) {
            deleteNodeInternal(root.left, key);
        }

    }
}
