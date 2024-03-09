package com.spa.leetcode;

public class CountOdds {

    //https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
    public int countOdds(int low, int high) {
        if(low == high){
            return low % 2 == 1 ? 1 : 0;
        }
        int count = 0;
        count += low % 2 == 1 ? 1 : 0;
        count += high % 2 == 1 ? 1 : 0;
        int insideInterval =  high - low  - 1;
        count += insideInterval / 2;
        if(low % 2 == high % 2 && low % 2 == 0){
           count++ ;
        }
        return count;
    }
}
