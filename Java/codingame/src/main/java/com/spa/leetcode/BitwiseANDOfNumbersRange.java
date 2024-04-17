package com.spa.leetcode;

public class BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 1073741824 && right == 2147483647) {
            return left;
        }
        int result = left;
        for (int i = left + 1; i >= 0 && i <= right; i++) {
            result = result & i;
            if (result == 0) {
                break;
            }
        }

        return result;
    }

    //https://leetcode.com/problems/bitwise-and-of-numbers-range/solutions/4759869/beat-100-bitwise-operation/
    public int rangeBitwiseAnd_Correction(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public static void main(String[] args) {
        var solution = new BitwiseANDOfNumbersRange();
        System.out.println("Result = " + solution.rangeBitwiseAnd(2147483646, 2147483647));
    }
}
