package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DuplicateZeros {

    // https://leetcode.com/problems/duplicate-zeros/submissions/1623831088/
    public void duplicateZeros(int[] arr) {
        List<Integer> result = new ArrayList<>(arr.length);

        int i = 0;
        while (result.size() < arr.length){
            if(arr[i] == 0){
                result.add(0);
                result.add(0);
            }else{
                result.add(arr[i]);
            }
            i++;
        }

        for (int j = 0; j < arr.length; j++) {
            arr[j] = result.get(j);
        }
    }
}
