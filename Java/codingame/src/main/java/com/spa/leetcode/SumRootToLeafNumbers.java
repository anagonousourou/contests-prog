package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/1233408773/?envType=daily-question&envId=2024-04-15
    public int sumNumbers(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        sumNumbers(root, "", numbers);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    private void sumNumbers(TreeNode root, String path, List<Integer> numbers) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            numbers.add(Integer.valueOf(path+root.val));
        }
        sumNumbers(root.left, path + root.val, numbers);
        sumNumbers(root.right, path + root.val, numbers);
    }
}
