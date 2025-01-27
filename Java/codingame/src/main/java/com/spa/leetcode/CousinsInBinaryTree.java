package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CousinsInBinaryTree {


    //https://leetcode.com/problems/cousins-in-binary-tree/description/
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, TreeNode> parents = new HashMap<>(2);
        Map<Integer, Integer> depths = new HashMap<>(2);
        traverse(root, x, y, null,0, parents, depths);
        return parents.get(x) != parents.get(y) && Objects.equals(depths.get(x), depths.get(y));
    }


    private void traverse(TreeNode root, int x, int y, TreeNode parent, int currentDepth, Map<Integer, TreeNode> parents, Map<Integer, Integer> depths) {
        if (root == null) {
            return;
        }

        if(root.val == x){
            parents.put(x, parent);
            depths.put(x, currentDepth + 1);
        }
        else if(root.val == y){
            parents.put(y, parent);
            depths.put(y, currentDepth + 1);
        }

        if (parents.size() == 2) {
            return;
        }

        traverse(root.right, x, y, root,currentDepth + 1, parents, depths);
        traverse(root.left, x, y, root,currentDepth + 1, parents, depths);
    }
}
