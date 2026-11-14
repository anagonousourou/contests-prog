package com.spa.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    // https://leetcode.com/problems/happy-number/submissions/1190917790/

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
