package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class UniValuedTree {


    // https://leetcode.com/problems/univalued-binary-tree/submissions/1619138279/
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> values = new HashSet<>();
        isUnivalTree(root, values);
        return values.size() == 1;
    }

    private void isUnivalTree(TreeNode root, Set<Integer> values) {
        values.add(root.val);
        if(root.left != null){
            isUnivalTree(root.left, values);
        }
        if(root.right != null){
            isUnivalTree(root.right, values);
        }
    }
}
