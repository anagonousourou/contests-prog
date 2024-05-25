package com.spa.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandPerimeter {

    private record Cell(int i, int j) {
    }

    //https://leetcode.com/problems/island-perimeter/submissions/1235856245/?envType=daily-question&envId=2024-04-18
    public int islandPerimeter(int[][] grid) {

        List<Cell> frontier = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {

                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        frontier.add(new Cell(i, j - 1));
                    }

                    if (j + 1 >= grid[i].length || grid[i][j + 1] == 0) {
                        frontier.add(new Cell(i, j + 1));
                    }

                    if (i - 1 < 0 || grid[i - 1][j] == 0) {
                        frontier.add(new Cell(i - 1, j));
                    }

                    if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
                        frontier.add(new Cell(i + 1, j));
                    }

                }
            }
        }

        return frontier.size();
    }
}
