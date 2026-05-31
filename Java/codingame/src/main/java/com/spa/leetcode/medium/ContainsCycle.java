package com.spa.leetcode.medium;

import java.util.*;

public class ContainsCycle {

    // https://leetcode.com/problems/detect-cycles-in-2d-grid/submissions/1988553337/?envType=daily-question&envId=2026-04-26
    record Cell(int i, int j, char c){}

    public boolean containsCycle(char[][] grid) {
        return isCycle(makeGraph(grid));
    }


    private Map<Cell, Set<Cell>> makeGraph(char[][] grid){
        Map<Cell, Set<Cell>> graph = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                var current = new Cell(i, j, grid[i][j]);
                graph.put(new Cell(i, j, grid[i][j]), new HashSet<>());
                if(i - 1 >= 0 && grid[i - 1][j] == grid[i][j]){
                    graph.get(current).add(new Cell(i -1, j, grid[i - 1][j]));
                }
                if(i + 1 < grid.length && grid[i + 1][j] == grid[i][j]) {
                    graph.get(current).add(new Cell(i +1, j, grid[i + 1][j]));
                }

                if(j - 1 >= 0 && grid[i][j - 1] == grid[i][j]){
                    graph.get(current).add(new Cell(i, j - 1, grid[i][j - 1]));
                }
                if(j + 1 < grid[i].length && grid[i][j + 1] == grid[i][j]) {
                    graph.get(current).add(new Cell(i, j + 1, grid[i][j + 1]));
                }

            }
        }

        return graph;
    }



        static boolean dfs(Cell v, Map<Cell, Set<Cell>> adj, Set<Cell> visited, Cell parent) {
            // Mark the current node as visited
            visited.add(v);

            // Recur for all the vertices adjacent to this vertex
            for (Cell neighbor : adj.get(v)) {

                // If an adjacent vertex is not visited,
                // then recur for that adjacent
                if (!visited.contains(neighbor)) {
                    if (dfs(neighbor, adj, visited, v))
                        return true;
                }
                // If an adjacent vertex is visited and is not
                // parent of current vertex,
                // then there exists a cycle in the graph.
                else if (!neighbor.equals(parent))
                    return true;
            }

            return false;
        }

        // Returns true if the graph contains a cycle, else false.
        static boolean isCycle(Map<Cell, Set<Cell>> adj) {
            // Mark all the vertices as not visited
            Set<Cell> visited = new HashSet<>();

            for (Cell u : adj.keySet()) {
                if (!visited.contains(u)) {
                    if (dfs(u, adj, visited, null))
                        return true;
                }
            }

            return false;
        }

}
