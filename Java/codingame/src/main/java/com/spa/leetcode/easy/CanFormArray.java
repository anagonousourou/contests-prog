package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class CanFormArray {

    // https://leetcode.com/problems/check-array-formation-through-concatenation/submissions/1624270025/
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] positions = new int[100];
        for (int i = 0; i < arr.length; i++) {
            positions[arr[i]] = i;
        }
        var newOrder = Arrays.stream(pieces).sorted(Comparator.comparingInt(piece -> positions[piece[0]]))
            .flatMap(piece -> Arrays.stream(piece).boxed())
            .toList();

        for (int i = 0; i < arr.length; i++) {
            if(newOrder.get(i) != arr[i]){
                return false;
            }
        }
        return true;
    }
}
