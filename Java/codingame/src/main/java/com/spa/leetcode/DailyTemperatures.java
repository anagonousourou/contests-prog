package com.spa.leetcode;

public class DailyTemperatures {

    //TOBECONTINUED (timeout)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 1; j + i < temperatures.length; j++) {
                if (temperatures[i + j] > temperatures[i]) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }
}
