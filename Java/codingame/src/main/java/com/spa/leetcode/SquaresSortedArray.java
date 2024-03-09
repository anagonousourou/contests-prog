package com.spa.leetcode;

import java.util.Arrays;

public class SquaresSortedArray {

    //O(n * log(n))
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }


    //Faster O(n) solution
    //https://leetcode.com/problems/squares-of-a-sorted-array/submissions/1191361027/
    public int[] sortedSquaresV2(int[] nums) {
        int [] result = new int[nums.length];
        int ngPtr = 0;
        int posPtr = 0;

        int i = 0;
        while (i < nums.length && nums[i] < 0){
            i++;
        }

        ngPtr = i - 1;

        posPtr = i;
        for (int j = 0; j < nums.length; j++) {
           if(ngPtr >= 0 && posPtr < nums.length){
               if(Math.abs(nums[ngPtr]) < Math.abs(nums[posPtr])){
                   result[j] = nums[ngPtr] * nums[ngPtr];
                   ngPtr--;
               }
               else{
                   result[j] = nums[posPtr] * nums[posPtr];
                   posPtr++;
               }
           }
           else if(posPtr < nums.length){
               result[j] = nums[posPtr] * nums[posPtr];
               posPtr++;
           }
           else if(ngPtr >= 0){
               result[j] = nums[ngPtr] * nums[ngPtr];
               ngPtr--;
           }
        }
        return result;
    }


}
