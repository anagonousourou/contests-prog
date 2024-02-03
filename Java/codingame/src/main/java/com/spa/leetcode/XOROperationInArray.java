package com.spa.leetcode;

public class XOROperationInArray {
    //https://leetcode.com/problems/xor-operation-in-an-array/description/
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }
}
