package com.spa.leetcode;

import java.util.BitSet;

public class MinIncrementForUnique {

    // https://leetcode.com/problems/minimum-increment-to-make-array-unique/submissions/1287889774/
    public int minIncrementForUnique(int[] nums) {
        BitSet bitSet = new BitSet(100_001);
        int totalInc = 0;
        for(int num : nums){
            if(bitSet.get(num)){
                //
                int nextUniqValue = bitSet.nextClearBit(num + 1);
                totalInc += (nextUniqValue - num);
                bitSet.set(nextUniqValue);
            }else{
                bitSet.set(num);
            }
        }

        return totalInc;
    }
}
