package com.spa.leetcode.easy;

import java.util.IdentityHashMap;
import java.util.List;

public class SnakeInMatrix {


    // https://leetcode.com/problems/snake-in-matrix/submissions/1554748497/
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;

        for (String command : commands) {
            if ("LEFT".equals(command)) {
                j--;
            } else if ("RIGHT".equals(command)) {
                j++;
            } else if ("DOWN".equals(command)) {
                i++;
            } else if ("UP".equals(command)) {
                i--;
            }
        }
        System.out.println("i " + i + "j = "+ j);
        return n * i + j;
    }
}
