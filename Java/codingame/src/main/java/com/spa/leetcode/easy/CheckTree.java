package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

public class CheckTree {

    //https://leetcode.com/problems/root-equals-sum-of-children/submissions/1167701410/
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
