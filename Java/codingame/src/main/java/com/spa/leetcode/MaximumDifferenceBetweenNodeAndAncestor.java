package com.spa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumDifferenceBetweenNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffV2(root, new HashMap<>(), 0);
    }

    private int maxAncestorDiffV2(TreeNode root , Map<TreeNode, TreeNode> parents, int max){
        if(root == null){
            return max;
        }

        var current = root;
        while (parents.containsKey(current)){
            current = parents.get(current);
            max = Math.max(Math.abs(root.val - current.val), max);
        }

        if(root.left != null){
            parents.put(root.left, root);
            max = maxAncestorDiffV2(root.left, parents, max);
        }

        if(root.right != null){
            parents.put(root.right, root);
            max = maxAncestorDiffV2(root.right, parents, max);
        }

        return max;
    }


    //cause memory limit exceeded
    private int maxAncestorDiff(TreeNode root , Set<Integer> ancestors, int max){
        if(root == null){
            return max;
        }

        for(var ancestor : ancestors){
            max = Math.max(Math.abs(root.val - ancestor), max);
        }

        if(root.left != null){
            Set<Integer> leftAncestors = new HashSet<>(ancestors);
            leftAncestors.add(root.val);
            max = maxAncestorDiff(root.left, leftAncestors, max);
        }

        if(root.right != null){
            Set<Integer> rightAncestors = new HashSet<>(ancestors);
            rightAncestors.add(root.val);
            max = maxAncestorDiff(root.right, rightAncestors, max);
        }

        return max;
    }
}
