package com.spa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DiameterOfBinaryTree {

    //https://leetcode.com/problems/diameter-of-binary-tree/submissions/1188031188/
    public int diameterOfBinaryTreeV2(TreeNode root) {
        height(root);
        return findMaxVal(root);
    }

    private int findMaxVal(TreeNode root){
        if(root.left == null && root.right == null){
            return root.val;
        }
        if(root.left == null){
            return Math.max(root.val, findMaxVal(root.right));
        }

        if(root.right == null){
            return Math.max(root.val, findMaxVal(root.left));
        }
        return Math.max(findMaxVal(root.right), Math.max(root.val, findMaxVal(root.left)));
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        root.val = leftHeight + rightHeight;
        return  1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        buildGraph(root, graph);
        List<TreeNode> leaves = graph.entrySet().stream().filter(treeNodeSetEntry -> treeNodeSetEntry.getValue().size() == 1)
            .map(Map.Entry::getKey).toList();

        int maxDiameter = 0;

        for (var leaf : leaves) {
            Queue<TreeNode> queue = new LinkedList<>();
            Map<TreeNode, Integer> nodesLevels = new HashMap<>();
            Set<TreeNode> encountered = new HashSet<>();
            queue.add(leaf);
            encountered.add(leaf);
            nodesLevels.put(leaf, 0);
            while (!queue.isEmpty()) {
                var v = queue.poll();

                for (var neighbor : graph.get(v)) {
                    if (!encountered.contains(neighbor)) {
                        encountered.add(neighbor);
                        queue.add(neighbor);
                        nodesLevels.put(neighbor, nodesLevels.get(v) + 1);
                    }
                }
            }

            maxDiameter = Math.max(maxDiameter, nodesLevels.values().stream().mapToInt(e -> e).max().getAsInt());


        }
        return maxDiameter;
    }

    private void buildGraph(TreeNode root, Map<TreeNode, Set<TreeNode>> graph) {
        if (root == null) {
            return;
        }
        if (!graph.containsKey(root)) {
            graph.put(root, new HashSet<>());
        }
        if (root.right != null) {
            graph.get(root).add(root.right);
            graph.put(root.right, new HashSet<>());
            graph.get(root.right).add(root);
        }
        if (root.left != null) {
            graph.get(root).add(root.left);
            graph.put(root.left, new HashSet<>());
            graph.get(root.left).add(root);
        }

        buildGraph(root.left, graph);
        buildGraph(root.right, graph);
    }
}
