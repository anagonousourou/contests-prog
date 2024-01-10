package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> content = new ArrayList<>();
        inorderTraversal(root, content);
        return content;
    }

    private void inorderTraversal(TreeNode root, List<Integer> content) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, content);
        content.add(root.val);
        inorderTraversal(root.right, content);
    }
}
