package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

public class SearchInBinarySearchTree {

    //https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/1135862748/
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
