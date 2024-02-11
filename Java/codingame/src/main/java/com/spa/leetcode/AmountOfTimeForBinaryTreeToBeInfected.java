package com.spa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountOfTimeForBinaryTreeToBeInfected {


    //https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);

        return exploreGraph(graph, start);
    }

    private int exploreGraph(Map<Integer, Set<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> nodesLevels = new HashMap<>();
        Set<Integer> encountered = new HashSet<>();
        queue.add(start);
        nodesLevels.put(start, 0);
        encountered.add(start);
        while (!queue.isEmpty()) {
            var v = queue.poll();

            for (var neighbor : graph.get(v)) {
                if (!encountered.contains(neighbor)) {
                    encountered.add(neighbor);
                    queue.add(neighbor);
                    nodesLevels.put(neighbor, nodesLevels.get(v) + 1);
                }
            }
            if (encountered.size() == graph.size()) {
                return nodesLevels.values().stream().mapToInt(e -> e).max().getAsInt();
            }
        }

        return nodesLevels.values().stream().mapToInt(e -> e).max().getAsInt();
    }

    private void buildGraph(TreeNode root, Map<Integer, Set<Integer>> graph) {
        if (root == null) {
            return;
        }
        if (!graph.containsKey(root.val)) {
            graph.put(root.val, new HashSet<>());
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.put(root.right.val, new HashSet<>());
            graph.get(root.right.val).add(root.val);
        }
        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.put(root.left.val, new HashSet<>());
            graph.get(root.left.val).add(root.val);
        }

        buildGraph(root.left, graph);
        buildGraph(root.right, graph);
    }
}
