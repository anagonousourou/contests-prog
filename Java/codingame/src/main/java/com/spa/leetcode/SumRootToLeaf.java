package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

    // https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/1415658973/
    public int sumRootToLeaf(TreeNode root) {
        List<String> paths = new ArrayList<>();
        sumRootToLeaf(root, paths, "");

        return paths.stream().map(path -> Integer.parseInt(path, 2)).mapToInt(Integer::intValue).sum();
    }


    public void sumRootToLeaf(TreeNode root, List<String> paths, String currentPath) {
        currentPath =  currentPath + root.val;

        if (root.left != null) {
            sumRootToLeaf(root.left, paths, currentPath);
        }
        if (root.right != null) {
            sumRootToLeaf(root.right, paths, currentPath);
        }
        if (root.left == null && root.right == null) {
            paths.add(currentPath);
        }
    }
}
