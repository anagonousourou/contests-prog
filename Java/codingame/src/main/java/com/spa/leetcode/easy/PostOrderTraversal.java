package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    // https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/1430394682/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> content = new ArrayList<>();
        postorderTraversal(root, content);
        return content;
    }

    private void postorderTraversal(TreeNode root, List<Integer> content) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, content);
        postorderTraversal(root.right, content);
        content.add(root.val);
    }
}
