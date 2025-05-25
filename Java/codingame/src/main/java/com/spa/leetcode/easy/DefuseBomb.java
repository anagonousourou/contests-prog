package com.spa.leetcode.easy;

public class DefuseBomb {

    // https://leetcode.com/problems/defuse-the-bomb/submissions/1556033664/
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];

        if(k > 0){
            for (int i = 0; i < result.length; i++) {
                for (int j = (i + 1) % code.length; j != (i + 1 + k) % code.length; j = (j + 1) % code.length) {
                    result[i] += code[j];
                }
            }
        }else if(k < 0){
            for (int i = 0; i < result.length; i++) {
                for (int j = (i - 1 + code.length) % code.length; j != (i - 1 + k + code.length) % code.length; j = (j - 1 + code.length) % code.length) {
                    result[i] += code[j];
                }
            }
        }

        return result;
    }
}
