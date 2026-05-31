package com.spa.leetcode.medium;

import java.util.Arrays;

public class DestroyingAsteroids {

    // https://leetcode.com/problems/destroying-asteroids/submissions/2018399417/?envType=daily-question&envId=2026-05-31
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;
        for (int asteroid: asteroids){
            if(currentMass < asteroid){
                return false;
            }{
                currentMass +=asteroid;
            }
        }
        return true;
    }
}
