package com.spa.leetcode;

public class MinimumCommonValue {

    //https://leetcode.com/problems/minimum-common-value/submissions/1198331180/
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer2 < nums2.length && pointer1 < nums1.length && nums1[pointer1] != nums2[pointer2]){
            if(nums1[pointer1] < nums2[pointer2]){
                pointer1++;
            }else{
                pointer2++;
            }
        }
        if(pointer2 < nums2.length && pointer1 < nums1.length){
            return nums1[pointer1];
        }else{
            return -1;
        }

    }
}
