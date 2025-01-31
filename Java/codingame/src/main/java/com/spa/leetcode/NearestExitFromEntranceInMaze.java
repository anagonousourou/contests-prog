package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NearestExitFromEntranceInMaze {

    private record Cell(int i, int j){}
    public int nearestExit(char[][] maze, int[] entrance) {
        Map<Cell, Set<Cell>> graph = new HashMap<>();
        Cell start = new Cell(entrance[0], entrance[1]);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == '.') {

                    var newcell = new Cell(i, j);
                    graph.putIfAbsent(newcell, new HashSet<>());
                    var adjs = graph.get(newcell);

                    if (j - 1 >= 0 && maze[i][j - 1] == '.') {
                        adjs.add(new Cell(i, j - 1));
                    }

                    if (j + 1 <  maze[i].length && maze[i][j + 1] == '.') {
                        adjs.add(new Cell(i, j + 1));
                    }

                    if (i - 1 >= 0 && maze[i - 1][j] == '.') {
                        adjs.add(new Cell(i - 1, j));
                    }

                    if (i + 1 < maze.length && maze[i + 1][j] == '.') {
                        adjs.add(new Cell(i + 1, j));
                    }

                }
            }
        }

        Set<Cell> seen = new HashSet<>();
        Deque<Cell> queue = new LinkedList<>();
        queue.add(start);

        int nbsteps = 0;
        while (!queue.isEmpty()){
            Cell current = queue.poll();
            if(isExit(current, maze) && !current.equals(start)){
                return nbsteps;
            }
            for(var neighbor : graph.get(current)){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
            nbsteps++;
        }



        return -1;
    }

    private boolean isExit(Cell cell, char[][] maze){
        return cell.i == 0 || cell.j == 0 || cell.i == maze.length || cell.j == maze[0].length;
    }


}
