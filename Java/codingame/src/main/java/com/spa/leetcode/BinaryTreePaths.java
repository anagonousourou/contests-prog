package com.spa.leetcode;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    //https://leetcode.com/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths("", root, result);
        return result;
    }

    private void binaryTreePaths(String currentPath, TreeNode root, List<String> result) {
        if(root == null){
            return;
        }
        String path = (currentPath.isBlank() ? "" : currentPath + "->") + root.val;
        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        binaryTreePaths(path, root.left, result);
        binaryTreePaths(path, root.right, result);
    }
}
