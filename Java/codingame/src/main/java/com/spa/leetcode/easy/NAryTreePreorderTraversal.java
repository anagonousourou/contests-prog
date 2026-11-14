package com.spa.leetcode.easy;

import com.spa.leetcode.Node;
import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {

    // https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/832079032/

        public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        visitDFS(root, result);
        return result;
    }

    public void visitDFS(Node root, List<Integer> visited) {
        if(root == null){
            return;
        }
        visited.add(root.val);
        if (root.children != null) {
            for (var child : root.children) {
                visitDFS(child, visited);
            }
        }
    }
}
