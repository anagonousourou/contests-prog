package com.spa.leetcode;

public class SumOfLeftLeaves {

    //https://leetcode.com/problems/sum-of-left-leaves/
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, true);
    }
    public int sumOfLeftLeaves(TreeNode root, boolean left) {
        if(root == null){
            return 0;
        }
        if(left && root.right == root.left && root.right == null){
            return root.val;
        }

        return sumOfLeftLeaves(root.right, false) + sumOfLeftLeaves(root.left, true);
    }
}
