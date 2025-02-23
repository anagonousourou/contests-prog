package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AllCellsDistanceOrder {

    // https://leetcode.com/problems/matrix-cells-in-distance-order/submissions/1484792597/
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        List<int[]> cells = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells.add(new int[]{i, j});
            }
        }

        cells.sort(Comparator.comparingInt(a -> Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)));
        return cells.toArray(new int[0][0]);
    }

}
