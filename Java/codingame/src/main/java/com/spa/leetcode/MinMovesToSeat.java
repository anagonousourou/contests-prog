package com.spa.leetcode;

import java.util.Arrays;

public class MinMovesToSeat {

    // https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/submissions/1286766189/?envType=daily-question&envId=2024-06-13
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
