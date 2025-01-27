package com.spa.leetcode.easy;

public class CheckBalancedString {


    // https://leetcode.com/problems/check-balanced-string/submissions/1478757576/
    public boolean isBalanced(String num) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < num.length(); i++) {
            if(i % 2 == 0){
                even += Character.getNumericValue(num.charAt(i));
            }else{
                odd += Character.getNumericValue(num.charAt(i));
            }
        }
        return odd == even;
    }
}
