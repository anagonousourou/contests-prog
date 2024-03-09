package com.spa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n, Set<Integer> results) {
        if(n == 1){
            return true;
        }
        int m = String.valueOf(n).chars().map(Character::getNumericValue).map(i -> i * i).sum();
        if(results.contains(m)){
            return false;
        }
        results.add(m);
        return isHappy(m, results);
    }

    //https://leetcode.com/problems/happy-number
    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }
}
