package com.spa.leetcode.medium;

import com.spa.leetcode.TreeNode;

public class CountCompleteTreeNodes {

    // https://leetcode.com/problems/count-complete-tree-nodes/submissions/1148893672/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
