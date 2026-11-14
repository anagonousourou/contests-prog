package com.spa.leetcode.medium;

import com.spa.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    // https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/832088868/

       public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> visited = new ArrayList<>();
        visitBFS(root, visited, 0);
        return visited;
    }

    public void visitBFS(TreeNode root, List<List<Integer>> visited, int level) {
        if (root == null) {
            return;
        }

        if (level < visited.size()) {
            visited.get(level).add(root.val);
        }
        else{
            visited.add(new ArrayList<>());
            visited.get(level).add(root.val);
        }

        visitBFS(root.left, visited, level + 1);
        visitBFS(root.right, visited, level + 1);
    }
}
