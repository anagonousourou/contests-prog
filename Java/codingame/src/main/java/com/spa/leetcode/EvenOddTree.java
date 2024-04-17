package com.spa.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenOddTree {

    //https://leetcode.com/problems/even-odd-tree/submissions/1189517694/
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, List<TreeNode>> nodesByLevel = new HashMap<>();
        isEvenOddTree(root, nodesByLevel, 0);
        for(var entry : nodesByLevel.entrySet()){
            if(entry.getKey() % 2 == 0){
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if(entry.getValue().get(i).val % 2 == 0){
                        return false;
                    }
                    if(i + 1 < entry.getValue().size() && entry.getValue().get(i).val >= entry.getValue().get(i + 1).val){
                        return false;
                    }
                }
            }else{
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if(entry.getValue().get(i).val % 2 == 1){
                        return false;
                    }
                    if(i + 1 < entry.getValue().size() && entry.getValue().get(i).val <= entry.getValue().get(i + 1).val){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void isEvenOddTree(TreeNode root, Map<Integer, List<TreeNode>> nodesByLevel, int currentLevel) {
        if(root == null){
            return;
        }
        isEvenOddTree(root.left, nodesByLevel, currentLevel + 1);

        if(nodesByLevel.containsKey(currentLevel)){
            nodesByLevel.get(currentLevel).add(root);
        }
        else{
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(root);
            nodesByLevel.put(currentLevel, nodes);
        }

        isEvenOddTree(root.right, nodesByLevel, currentLevel + 1);
    }
}
