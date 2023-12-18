package com.spa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {

        if (points.length <= 2) {
            return points.length;
        }

        int overallMax = 2;
        Set<String> pairsChecked = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j && !pairsChecked.contains("%d,%d".formatted(i, j)) && !pairsChecked.contains("%d,%d".formatted(j, i))) {
                    pairsChecked.add("%d,%d".formatted(i, j));
                    pairsChecked.add("%d,%d".formatted(j, i));
                    int currentCount = 2;
                    for (int k = 0; k < points.length; k++) {
                        if (k != i && k != j) {
                            if (belongsTo(points[i], points[j], points[k])) {
                                currentCount++;
                            }
                        }
                    }
                    overallMax = Math.max(overallMax, currentCount);
                }
            }

        }
        return overallMax;
    }


    public boolean belongsTo(int[] pointA, int[] pointB, int[] pointM) {
        int[] vectorAB = new int[]{pointB[0] - pointA[0], pointB[1] - pointA[1]};
        int[] vectorAM = new int[]{pointM[0] - pointA[0], pointM[1] - pointA[1]};

        return vectorAM[0] * vectorAB[1] == vectorAM[1] * vectorAB[0];
    }
}
