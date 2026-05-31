package com.spa.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {

    record DailyTemperature(int temperature, int day){}

    //https://leetcode.com/problems/daily-temperatures/submissions/2018466071/?envType=problem-list-v2&envId=dsa-linear-shoal-monotonic-stack
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<DailyTemperature> temps = new LinkedList<>();

        int[] result = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            if(temps.isEmpty()){
                temps.push(new DailyTemperature(temperatures[i], i));
            }
            else if(temps.peek().temperature() > temperatures[i]){
                result[i] = temps.peek().day() - i;
                temps.push(new DailyTemperature(temperatures[i], i));
            }else if(temps.peek().temperature() <= temperatures[i]){
                while (!temps.isEmpty() && temps.peek().temperature() <= temperatures[i]){
                    temps.pop();
                }
                if(!temps.isEmpty()){
                    result[i] = temps.peek().day() - i;
                }
                temps.push(new DailyTemperature(temperatures[i], i));
            }
        }
        return result;
    }
}
