package com.spa.leetcode;

public class ColorOfChessbordSquare {

    //https://leetcode.com/problems/determine-color-of-a-chessboard-square/
    public boolean squareIsWhite(String coordinates) {
        int x = (coordinates.charAt(0) - 'a') + 1;
        int y = Character.getNumericValue(coordinates.charAt(1));
        return x % 2 != y % 2;
    }
}
