package com.spa.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfIslands {

    // https://leetcode.com/problems/number-of-islands/submissions/835300362/

   public int numIslands(char[][] grid) {
        Map<String, Set<String>> connexions = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String currentPlace = "%d-%d".formatted(i, j);
                Set<String> nextPlaces = new HashSet<>();
                if (i + 1 < grid.length && grid[i][j] == grid[i + 1][j] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i + 1, j));
                }
                if (j + 1 < grid[i].length && grid[i][j] == grid[i][j + 1] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i, j + 1));
                }

                if (j - 1 >= 0 && grid[i][j] == grid[i][j - 1] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i, j - 1));
                }

                if (i - 1 >= 0 && grid[i][j] == grid[i - 1][j] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i - 1, j));
                }

                if (grid[i][j] == '1') {
                    connexions.put(currentPlace, nextPlaces);
                }

            }
        }

        System.out.println(connexions);

        int islandsCount = 0;
        Set<String> visited = new HashSet<>();

        for (var connexion : connexions.entrySet()) {
            if (!visited.contains(connexion.getKey())) {
                islandsCount++;
                visitFrom(connexion.getKey(), visited, connexions);
            }
        }

        return islandsCount;
    }

    private void visitFrom(String startingPoint, Set<String> visited, Map<String, Set<String>> connexions) {
        if (visited.contains(startingPoint)) {
            return;
        }
        visited.add(startingPoint);

        if (!connexions.containsKey(startingPoint)) {
            return;
        }
        for (String neighbor : connexions.get(startingPoint)) {
            visitFrom(neighbor, visited, connexions);
        }
    }
}
