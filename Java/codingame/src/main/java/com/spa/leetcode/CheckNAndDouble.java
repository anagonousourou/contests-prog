package com.spa.leetcode;


public class CheckNAndDouble {

    // https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i != j && arr[i] * 2 == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
