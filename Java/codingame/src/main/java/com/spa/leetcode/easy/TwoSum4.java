package com.spa.leetcode.easy;

import com.spa.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSum4 {


    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/1528720892/
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> elements = inorderTraversal(root);
        for (int i = 0; i < elements.size(); i++) {
                int index = Collections.binarySearch(elements, k - elements.get(i));
                if(index >= 0 && index != i){
                    return true;
                }
        }
        return false;
    }


    private List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> content = new ArrayList<>();
        inorderTraversal(root, content);
        return content;
    }

    private void inorderTraversal(TreeNode root, List<Integer> content) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, content);
        content.add(root.val);
        inorderTraversal(root.right, content);
    }
}
