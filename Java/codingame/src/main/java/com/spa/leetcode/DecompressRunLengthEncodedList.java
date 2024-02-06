package com.spa.leetcode;


//https://leetcode.com/problems/decompress-run-length-encoded-list/submissions/1167634294/
public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int resultLength = 0;
        for (int i = 0; i < nums.length; i+=2) {
            resultLength += nums[i];
        }

        int[] result = new int[resultLength];

        int j = 0;
        for (int i = 0; i < nums.length; i+=2) {
            for (int k = 0; k < nums[i]; k++) {
                result[j] = nums[i+1];
                j++;
            }
        }

        return result;
    }
}
