package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {

    //https://leetcode.com/problems/k-closest-points-to-origin/
    public int[][] kClosest(int[][] points, int k) {
       return Arrays.stream(points).sorted(Comparator.comparingDouble(point -> Math.hypot(point[0], point[1])))
            .limit(k).toArray(int[][]::new);
    }
}
