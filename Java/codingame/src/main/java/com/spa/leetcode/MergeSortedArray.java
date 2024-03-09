package com.spa.leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    //https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1,m,n );

        Arrays.sort(nums1);
    }

    //https://leetcode.com/problems/merge-sorted-array/submissions/1191825292/
    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int[] arr1 = new int[m];
        System.arraycopy(nums1, 0, arr1, 0, m);

        int ptr1 = 0;
        int ptr2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(ptr2 < n && ptr1 < m){
                if(arr1[ptr1] < nums2[ptr2]){
                    nums1[i] = arr1[ptr1];
                    ptr1++;
                }else{
                    nums1[i] = nums2[ptr2];
                    ptr2++;
                }
            }
            else if(ptr2 < n){
                nums1[i] = nums2[ptr2];
                ptr2++;
            }else{
                nums1[i] = arr1[ptr1];
                ptr1++;
            }
        }
    }
}
