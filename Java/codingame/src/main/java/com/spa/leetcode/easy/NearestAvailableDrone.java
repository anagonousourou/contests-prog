package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class NearestAvailableDrone {


    // https://leetcode.com/problems/nearest-available-drone/submissions/2136035624/
    public int nearestDrone(int[][] drones, int[] target) {
        return Arrays.stream(drones)
            .filter(drone -> Math.abs(target[0] - drone[0]) + Math.abs(target[1] - drone[1]) <= drone[2])
            .min(Comparator.comparing(drone -> Math.abs(target[0] - drone[0]) + Math.abs(target[1] - drone[1])))
            .map(drone -> Arrays.asList(drones).indexOf(drone))
            .orElse(-1);
    }
}
