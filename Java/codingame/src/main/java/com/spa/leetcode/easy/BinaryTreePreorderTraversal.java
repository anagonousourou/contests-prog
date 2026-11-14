package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    // https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/874693908/

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
