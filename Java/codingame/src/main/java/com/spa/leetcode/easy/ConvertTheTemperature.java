package com.spa.leetcode.easy;

public class ConvertTheTemperature {

    //https://leetcode.com/problems/convert-the-temperature/submissions/1161849002/description/
    public double[] convertTemperature(double celsius) {
        return new double[]{273.15 + celsius, celsius * 1.80 + 32.00};
    }
}
