package com.spa.leetcode.easy;

public class ColorOfChessbordSquare {

    //https://leetcode.com/problems/determine-color-of-a-chessboard-square/submissions/1175012565/
    public boolean squareIsWhite(String coordinates) {
        int x = (coordinates.charAt(0) - 'a') + 1;
        int y = Character.getNumericValue(coordinates.charAt(1));
        return x % 2 != y % 2;
    }
}
