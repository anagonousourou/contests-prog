package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PivotArray {

    //https://leetcode.com/problems/partition-array-according-to-given-pivot/submissions/1562362600/?envType=daily-question&envId=2025-03-03
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> equalToPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                lessThanPivot.add(num);
            } else if (num == pivot) {
                equalToPivot.add(num);
            } else {
                greaterThanPivot.add(num);
            }
        }

        // Combine the three lists into one array
        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(lessThanPivot);
        resultList.addAll(equalToPivot);
        resultList.addAll(greaterThanPivot);


        int[] resultArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

}
