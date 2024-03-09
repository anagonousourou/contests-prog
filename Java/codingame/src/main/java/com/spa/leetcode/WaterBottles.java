package com.spa.leetcode;

public class WaterBottles {

    //https://leetcode.com/problems/water-bottles/description/
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + numWaterBottles(numBottles / numExchange, numExchange, numBottles % numExchange);
    }

    private int numWaterBottles(int numBottles, int numExchange, int remainder) {
        //System.out.println("numBottles = %d, numExchange = %d, remainder= %d".formatted(numBottles, numExchange, remainder));
        if (numBottles == 0) {
            return 0;
        }

        return numBottles + numWaterBottles((numBottles + remainder) / numExchange, numExchange, (numBottles + remainder) % numExchange);
    }

    public static void main(String[] args) {
        var solution = new WaterBottles();
        System.out.println(solution.numWaterBottles(15, 4));
    }
}
