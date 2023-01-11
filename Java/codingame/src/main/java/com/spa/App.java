package com.spa;

import com.spa.leetcode.GasStation;
import com.spa.leetcode.SolutionLeetCode;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        var algos = new GasStation();
       System.out.println(algos.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); ;
    }



}
