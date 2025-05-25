package com.spa.leetcode.medium;

import com.spa.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LcaDeepestLeaves {


    // https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/submissions/1597644440/?envType=daily-question&envId=2025-04-04
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        Map<TreeNode, Integer> depth = new HashMap<>();

        Map<TreeNode, TreeNode> parents = new HashMap<>();

        computeNodesDepth(root, 0, depth);
        computeParents(root, null, parents);

        var deepestNodes = depth.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), depth.values().stream().max(Integer::compareTo).orElseThrow()))
            .toList();

        var ancestorsOfDeepestNodes = deepestNodes.stream().map(entry -> getAncestors(entry.getKey(), parents)).toList();

        if(deepestNodes.size() == 1){
            return deepestNodes.get(0).getKey();
        }

        int p = ancestorsOfDeepestNodes.get(0).size();

        for (int i = 0; i < p; i++) {
            boolean ok = true;
            for (int j = 1; j < ancestorsOfDeepestNodes.size(); j++) {
                if(ancestorsOfDeepestNodes.get(j).get(i) != ancestorsOfDeepestNodes.get(0).get(i)){
                    ok = false;
                    break;
                }
            }
            if (ok){
                return ancestorsOfDeepestNodes.get(0).get(i);
            }
        }

        return root;
    }


    private List<TreeNode> getAncestors(TreeNode node, Map<TreeNode, TreeNode> parents){
        List<TreeNode> ancestors = new ArrayList<>();

        while (parents.get(node) != null){
            node = parents.get(node);
            ancestors.add(node);
        }
        return ancestors;
    }

    private void computeParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents){
        parents.put(node, parent);
        if(node.left != null){
            computeParents(node.left, node, parents);
        }
        if(node.right != null){
            computeParents(node.right, node, parents);
        }
    }

    private void computeNodesDepth(TreeNode node, int currentDepth, Map<TreeNode, Integer> depths){
        depths.put(node, currentDepth);
        if(node.left != null){
            computeNodesDepth(node.left, currentDepth + 1, depths);
        }
        if(node.right != null){
            computeNodesDepth(node.right, currentDepth + 1, depths);
        }
    }
}
