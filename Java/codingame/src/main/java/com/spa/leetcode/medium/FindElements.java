package com.spa.leetcode.medium;

import com.spa.leetcode.TreeNode;

import java.util.BitSet;

// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/submissions/1550600743/?envType=daily-question&envId=2025-02-21
public class FindElements {

    private final BitSet bitSet = new BitSet(1_000_000);

    public FindElements(TreeNode root) {
        root.val = 0;
        bitSet.set(root.val);
        initialize(root);
    }

    private void initialize(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {

            root.left.val = root.val * 2 + 1;
            bitSet.set(root.left.val);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            bitSet.set(root.right.val);
        }
        initialize(root.right);
        initialize(root.left);
    }

    public boolean find(int target) {
        return bitSet.get(target);
    }
}
