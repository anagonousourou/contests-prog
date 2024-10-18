package com.spa.leetcode.easy;

import java.util.Arrays;

public class CanThreePartsEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int firstPartition = -1;
        int sndPartition = -1;
        for (int i = 0; i < arr.length; i++) {
            if (prefix[i] == prefix[prefix.length - 1] / 3 && prefix[prefix.length - 1] % 3 == 0 && firstPartition == -1) {
                firstPartition = i;
            }

            if (prefix[i] == (2 * prefix[prefix.length - 1]) / 3
                && prefix[prefix.length - 1] % 3 == 0
                && firstPartition != -1
                && sndPartition == -1
                && firstPartition != i
                && i != arr.length - 1) {
                sndPartition = i;
            }
        }

        System.out.println("prefix " + Arrays.toString(prefix));

        System.out.println("firstPart " + firstPartition + " secondPart " + sndPartition);
        return firstPartition != -1 && sndPartition != -1;
    }
}
