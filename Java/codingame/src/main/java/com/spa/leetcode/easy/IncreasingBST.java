package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    // https://leetcode.com/problems/increasing-order-search-tree/submissions/1430230282/
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>(100);
        inOrderTraversal(root, nodes);

        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).left = null;
            if (i + 1 < nodes.size()) {
                nodes.get(i).right = nodes.get(i + 1);
            } else {
                nodes.get(i).right = null;
            }
        }

        return nodes.get(0);
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> content) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, content);
        content.add(root);
        inOrderTraversal(root.right, content);
    }
}
