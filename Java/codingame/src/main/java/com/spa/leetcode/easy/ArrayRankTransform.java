package com.spa.leetcode.easy;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * ArrayRankTransform
 */
public class ArrayRankTransform {


    // https://leetcode.com/problems/rank-transform-of-an-array/submissions/2072148378/?envType=daily-question&envId=2026-07-12
    record Number(int value, int initialIndex){}
    public int[] arrayRankTransform(int[] arr) {
       var sortedNumbers = IntStream.range(0, arr.length).mapToObj(i -> new Number(arr[i], i))
        .sorted(Comparator.comparing(Number::value))
        .toList();


        int[] ranks = new int[arr.length];
        int rank = 1;
        for (int j = 0; j < sortedNumbers.size(); j++) {
            if(j > 0 && sortedNumbers.get(j-1).value() != sortedNumbers.get(j).value()){
                rank++;
            }
            ranks[sortedNumbers.get(j).initialIndex()] = rank;
        }
        return ranks;
    }

}
