package com.spa.leetcode;

import java.util.Arrays;

public class MaxScoreSplitingString {

    public int maxScore(String s) {
        int[] nbZeros = new int[s.length()];
        int[] nbOnes = new int[s.length()];

        nbZeros[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == '0'){
                nbZeros[i] = nbZeros[i - 1] + 1;
            }else{
                nbZeros[i] = nbZeros[i - 1];
            }
        }

        nbOnes[s.length() - 1] = 0;
        for (int i = s.length() - 2 ;  i >= 0; i--) {
            if(s.charAt(i + 1) == '1'){
                nbOnes[i] = nbOnes[i + 1] + 1;
            }else{
                nbOnes[i] = nbOnes[i + 1];
            }
        }

        System.out.println("NB_ZEROS = "+ Arrays.toString(nbZeros));
        System.out.println("NB_ONES = "+ Arrays.toString(nbOnes));
        int maxScore = 0;
        for (int i = 1; i <= s.length() - 1 ; i++) {
            maxScore = Math.max(maxScore, nbZeros[i] + nbOnes[i - 1]);
        }

        return maxScore;
    }
}
