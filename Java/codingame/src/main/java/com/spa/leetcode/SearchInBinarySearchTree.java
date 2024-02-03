package com.spa.leetcode;

public class SearchInBinarySearchTree {

    //https://leetcode.com/problems/search-in-a-binary-search-tree/
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
