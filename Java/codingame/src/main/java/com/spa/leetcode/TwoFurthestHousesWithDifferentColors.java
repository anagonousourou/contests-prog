package com.spa.leetcode;

public class TwoFurthestHousesWithDifferentColors {

    //https://leetcode.com/problems/two-furthest-houses-with-different-colors/
    public int maxDistance(int[] colors) {

        int front = 0;
        int back = colors.length - 1;
        while (front < back && colors[front] == colors[back]){
            front++;
        }
        int distance = back - front;

        front = 0;
        back = colors.length - 1;
        while (front < back && colors[front] == colors[back]){
            back--;
        }
        return Math.max(distance, back - front);

    }
}
