package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeArrayEmpty {

    //https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
    public int minOperations(int[] nums) {
        var occurrences = StringHelpers.frequenciesInteger(Arrays.stream(nums).boxed().toList());

        if (occurrences.values().stream().anyMatch(i -> i == 1)) {
            return -1;
        }
        int nboperations = 0;
        for (var numberCount : occurrences.entrySet()) {
            if (numberCount.getValue() % 3 == 0) {
                nboperations += numberCount.getValue() / 3;
            } else {
                var xy = solve(numberCount.getValue());
                if (xy[0] + xy[1] == 0) {
                    //could not solve
                    return -1;
                } else {
                    nboperations += xy[0] + xy[1];
                }
            }
        }
        return nboperations;

    }

    int[] solve(int s) {
        //3x + 2y == s
        //with x + y > 0, x >= 0 && y >= 0, and x + y is minimum

        //we create the system of equation
        //3x + 2y = s
        // x + y = t
        //solve for x, and y depending on s and t
        //we find x = -2t + s
        //and y = 3t - s
        //since we are looking to make t minimum then we can return as soon as we find a value of t that satisfy x > 0 && y > 0
        int[] xy = new int[2];
        for (int t = 1; t <= s / 2; t++) {
            if (3 * t - s >= 0 && -2 * t + s >= 0) {
                xy[0] = -2 * t + s;
                xy[1] = 3 * t - s;
                return xy;
            }
        }
        return xy;
    }

    //slow solve
    int[] solve2(int s) {
        //3x + 2y == s
        //with x + y > 0 && x + y is minimum
        int[] xy = new int[2];
        for (int x = 0; x <= s / 3; x++) {
            for (int y = 0; y <= s / 2; y++) {
                if (3 * x + 2 * y == s && (xy[0] + xy[1] == 0 || x + y < xy[0] + xy[1])) {
                    xy[0] = x;
                    xy[1] = y;
                }
            }
        }
        return xy;
    }
}
