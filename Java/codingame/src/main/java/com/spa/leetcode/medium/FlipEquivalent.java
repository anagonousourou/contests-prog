package com.spa.leetcode.medium;

import com.spa.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlipEquivalent {

    // https://leetcode.com/problems/flip-equivalent-binary-trees/submissions/1432270418/?envType=daily-question&envId=2024-10-24
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Map<Integer, Set<Integer>> relations1 = new HashMap<>();
        Map<Integer, Set<Integer>> relations2 = new HashMap<>();
        getRelations(root1, relations1);
        getRelations(root2, relations2);
        return relations1.equals(relations2);
    }

    private static void getRelations(TreeNode root, Map<Integer, Set<Integer>> relations) {
        if (root == null) {
            return;
        }
        var childrens = new HashSet<Integer>(2);
        if (root.left != null) {
            childrens.add(root.left.val);
        }
        if (root.right != null) {
            childrens.add(root.right.val);
        }

        relations.put(root.val, childrens);

        getRelations(root.left, relations);
        getRelations(root.right, relations);
    }
}
