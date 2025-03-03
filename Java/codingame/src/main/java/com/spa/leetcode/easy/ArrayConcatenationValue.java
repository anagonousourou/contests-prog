package com.spa.leetcode.easy;

public class ArrayConcatenationValue {

    // https://leetcode.com/problems/find-the-array-concatenation-value/submissions/1521902016/
    public long findTheArrayConcVal(int[] nums) {
       int front = 0;
       int back = nums.length - 1;
       long result = 0;
       while (front <= back){
           if(front != back){
               result += Integer.parseInt( String.valueOf(nums[front]) + nums[back]);
           }else{
               result += nums[front];
           }
           front++;
           back--;
       }
       return result;
    }
}
