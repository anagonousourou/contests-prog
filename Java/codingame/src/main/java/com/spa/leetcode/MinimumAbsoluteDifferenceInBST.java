package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/submissions/1233387827/
    public int getMinimumDifference(TreeNode root) {
        List<Integer> elts = new ArrayList<>();
        getValues(root, elts);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < elts.size() - 1; i++) {
            min = Math.min(min, Math.abs(elts.get(i + 1) - elts.get(i)));
        }
        return min;
    }

    public void getValues(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        getValues(root.left, list);
        list.add(root.val);
        getValues(root.right, list);
    }
}
