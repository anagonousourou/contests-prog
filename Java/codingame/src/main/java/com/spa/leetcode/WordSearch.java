package com.spa.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO
public class WordSearch {

    record Cell(char value, int i, int j) {

    }

    public boolean exist(char[][] board, String word) {
        char[] wordchars = word.toCharArray();
        Map<Cell, Set<Cell>> adjacentCells = new HashMap<>();
        Map<String, Cell> mapByPosition = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Cell newCell = new Cell(board[i][j], i, j);
                adjacentCells.put(newCell, new HashSet<>());
                mapByPosition.put(String.format("%d-%d", i, j), newCell);
            }
        }

        //init neighbors
        for (var entry : adjacentCells.entrySet()) {
            String belowKey = String.format("%d-%d", entry.getKey().i + 1, entry.getKey().j);
            String upKey = String.format("%d-%d", entry.getKey().i - 1, entry.getKey().j);
            String leftKey = String.format("%d-%d", entry.getKey().i, entry.getKey().j - 1);
            String rightKey = String.format("%d-%d", entry.getKey().i, entry.getKey().j + 1);

            for (String key : List.of(belowKey, upKey, leftKey, rightKey)) {
                if (mapByPosition.containsKey(key)) {
                    entry.getValue().add(mapByPosition.get(key));
                }
            }
        }


        Deque<Cell> next = new LinkedList<>();
        Map<Cell, Integer> depth = new HashMap<>();
        adjacentCells.keySet().stream().filter(cell -> cell.value == wordchars[0]).forEach(cell ->
            {
                next.add(cell);
                depth.put(cell, 0);
            });
        Set<Cell> used = new HashSet<>();
        System.out.println("Pile " + next);
        while (!next.isEmpty()) {
            Cell current = next.pop();
            if (!used.contains(current)) {
                used.add(current);
                for (var neighbor : adjacentCells.get(current)) {
                    if (!used.contains(neighbor) && (depth.get(current) + 1) < wordchars.length &&  neighbor.value == wordchars[depth.get(current) + 1]) {
                        next.push(neighbor);
                        depth.put(neighbor, depth.get(current) + 1);
                        System.out.println(depth);
                        if (depth.get(neighbor) == wordchars.length - 1) {
                            return true;
                        }
                    }
                }
            }

        }

        return depth.containsValue(wordchars.length - 1);
    }


}
