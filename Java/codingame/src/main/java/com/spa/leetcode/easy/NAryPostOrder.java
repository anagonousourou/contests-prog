package com.spa.leetcode.easy;


import com.spa.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryPostOrder {

    // https://leetcode.com/problems/n-ary-tree-postorder-traversal/submissions/1549746018/
    public List<Integer> postorder(Node root) {
        List<Integer> content = new ArrayList<>();
        postorderTraversal(root, content);
        return content;
    }

    private void postorderTraversal(Node root, List<Integer> content) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (var child : root.children) {
                postorderTraversal(child, content);
            }
        }
        content.add(root.val);
    }
}
