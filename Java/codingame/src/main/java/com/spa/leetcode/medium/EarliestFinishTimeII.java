package com.spa.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/?envType=daily-question&envId=2026-06-03
public class EarliestFinishTimeII {

    enum RideType {
        WATER, LAND
    }

    record Ride(int startTime, int duration, RideType rideType) {
        int finishTime() {
            return startTime + duration;
        }
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        List<Ride> land = new ArrayList<>();
        List<Ride> water = new ArrayList<>();

        for (int i = 0; i < landStartTime.length; i++) {
            land.add(new Ride(landStartTime[i], landDuration[i], RideType.LAND));
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            water.add(new Ride(waterStartTime[i], waterDuration[i], RideType.WATER));
        }

        // Sort both by start time
        land.sort(Comparator.comparingInt(Ride::startTime));
        water.sort(Comparator.comparingInt(Ride::startTime));

        int result = Math.min(
            computeMinTotal(water, land), // Water first, then Land
            computeMinTotal(land, water) // Land first, then Water
        );

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int computeMinTotal(List<Ride> first, List<Ride> second) {
        if (first.isEmpty() || second.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        // Precompute for 'second' array:
        // 1. prefixMinDuration[i] = minimum duration among second[0..i]
        int[] prefixMinDuration = new int[second.size()];
        int minDur = Integer.MAX_VALUE;
        for (int i = 0; i < second.size(); i++) {
            minDur = Math.min(minDur, second.get(i).duration());
            prefixMinDuration[i] = minDur;
        }

        // 2. suffixMinFinish[i] = minimum finish time among second[i..n-1]
        int[] suffixMinFinish = new int[second.size() + 1];
        suffixMinFinish[second.size()] = Integer.MAX_VALUE;
        int minFinish = Integer.MAX_VALUE;
        for (int i = second.size() - 1; i >= 0; i--) {
            minFinish = Math.min(minFinish, second.get(i).finishTime());
            suffixMinFinish[i] = minFinish;
        }

        int minTotal = Integer.MAX_VALUE;

        // For each ride in 'first', find the best matching ride in 'second'
        for (Ride firstRide : first) {
            int firstFinish = firstRide.finishTime();

            // Binary search to find the split point:
            // rides with startTime <= firstFinish go to "delayed" group
            // rides with startTime > firstFinish go to "as-is" group
            int left = 0, right = second.size() - 1;
            int splitIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (second.get(mid).startTime() <= firstFinish) {
                    splitIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Group 1: rides that start AT or BEFORE firstFinish
            // These will start at firstFinish, so total = firstFinish + duration
            if (splitIndex >= 0) {
                int bestDuration = prefixMinDuration[splitIndex];
                int total = firstFinish + bestDuration;
                minTotal = Math.min(minTotal, total);
            }

            // Group 2: rides that start AFTER firstFinish
            // These start at their own startTime, so total = finishTime (start+duration)
            if (splitIndex + 1 < second.size()) {
                int bestFinish = suffixMinFinish[splitIndex + 1];
                minTotal = Math.min(minTotal, bestFinish);
            }
        }

        return minTotal;
    }
}
