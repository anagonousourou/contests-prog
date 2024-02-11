package com.spa.leetcode;

public class ConvertTheTemperature {

    //https://leetcode.com/problems/convert-the-temperature/description/
    public double[] convertTemperature(double celsius) {
        return new double[]{273.15 + celsius, celsius * 1.80 + 32.00};
    }
}
