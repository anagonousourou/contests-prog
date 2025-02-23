package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;



public class FindBottomLeftTreeValue {

    //https://leetcode.com/problems/find-bottom-left-tree-value/description/
    private record ValueDepth(int depth, int value){}

    public int findBottomLeftValue(TreeNode root) {
        List<ValueDepth> leaves = new ArrayList<>();
        findBottomLeftValue(root, leaves, 0);
        int maxdepth = leaves.stream().mapToInt(ValueDepth::depth).max().getAsInt();
        return leaves.stream().filter(node -> node.depth == maxdepth).findFirst().orElseThrow().value;
    }

    public void findBottomLeftValue(TreeNode root, List<ValueDepth> nodeList, int depth) {

        if(root.left == null && root.right == null){
            nodeList.add(new ValueDepth(depth, root.val));
        }
        if(root.left != null){
            findBottomLeftValue(root.left , nodeList, depth + 1);
        }
        if(root.right != null){
            findBottomLeftValue(root.right , nodeList, depth + 1);
        }
    }
}
