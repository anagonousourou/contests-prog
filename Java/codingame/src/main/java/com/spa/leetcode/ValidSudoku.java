package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {


    //https://leetcode.com/problems/valid-sudoku/
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isRowValid(board[i])) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (!isColumnValid(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isSectionValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isRowValid(char[] row) {
        Map<Character, Integer> count = new HashMap<>(10);
        for (var c : row) {
            if (c == '.') {
                continue;
            }
            if (!(c >= '1' && c <= '9')) {
                return false;
            }
            if (count.getOrDefault(c, 0) == 1) {
                return false;
            }
            count.put(c, 1);
        }
        return true;
    }

    private boolean isSectionValid(char[][] board, int startRow, int startColumn) {
        Map<Character, Integer> count = new HashMap<>(10);

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!(board[i][j] >= '1' && board[i][j] <= '9')) {
                    return false;
                }
                if (count.getOrDefault(board[i][j], 0) == 1) {
                    return false;
                }
                count.put(board[i][j], 1);
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board, int columnIndex) {
        Map<Character, Integer> count = new HashMap<>(10);
        for (char[] row : board) {
            if (row[columnIndex] == '.') {
                continue;
            }
            if (!(row[columnIndex] >= '1' && row[columnIndex] <= '9')) {
                return false;
            }
            if (count.getOrDefault(row[columnIndex], 0) == 1) {
                return false;
            }
            count.put(row[columnIndex], 1);
        }
        return true;
    }
}
