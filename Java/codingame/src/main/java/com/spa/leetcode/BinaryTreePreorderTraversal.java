package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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
