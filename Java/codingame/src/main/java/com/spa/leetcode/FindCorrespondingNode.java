package com.spa.leetcode;

public class FindCorrespondingNode {


    //https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }
        if (original == null) {
            return null;
        }
        TreeNode answer = getTargetCopy(original.right, cloned.right, target);
        if (answer != null) {
            return answer;
        }

        return getTargetCopy(original.left, cloned.left, target);

    }
}
