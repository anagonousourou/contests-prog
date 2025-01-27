package com.spa.leetcode;

public class DistanceBetweenBusStops {

    // https://leetcode.com/problems/distance-between-bus-stops/submissions/1416918800/
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // go forward
        int forwardDistance = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            forwardDistance += distance[i];
        }

        // go backward
        int backwardDistance = 0;
        for (int i = start; i != destination; i = (i - 1 + distance.length) % distance.length) {
            backwardDistance += distance[(i - 1 + distance.length) % distance.length];
        }
        // take the minimum distance of both ways
        return Math.min(backwardDistance, forwardDistance);
    }
}
