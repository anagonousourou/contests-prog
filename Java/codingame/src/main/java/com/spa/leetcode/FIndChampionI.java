package com.spa.leetcode;


import java.util.stream.IntStream;

public class FIndChampionI {

    //https://leetcode.com/problems/find-champion-i/submissions/1195046830/
    public int findChampion(int[][] grid) {
        for (int j = 0; j < grid.length; j++) {
            int finalJ = j;
            if(IntStream.range(0, grid.length).allMatch(i -> grid[i][finalJ] == 0)){
                return j;
            }
        }
        return -1;
    }
}
