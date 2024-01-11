package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    //https://leetcode.com/problems/leaf-similar-trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null & root.right == null) {
            result.add(root.val);
            return;
        }
        getLeaves(root.left, result);
        getLeaves(root.right, result);
    }
}
