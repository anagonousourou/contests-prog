package com.spa.leetcode;

import java.util.List;
import java.util.Objects;

public class ElementAppearingMoreThan25Percent {

    //https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
    public int findSpecialInteger(int[] arr) {
        int l = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if((i + l / 4) < l && arr[i] == arr[i + l / 4]){
                return arr[i];
            }
        }
        return -1;
    }
}
