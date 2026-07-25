package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/submissions/2020474078/?envType=daily-question&envId=2026-06-02
public class EarliestFinishTime {

    enum RideType{
        WATER,
        LAND
    }
    record Ride(int startTime, int duration, RideType rideType){

        int finishTime(){
            return startTime + duration;
        }
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        List<Ride> landRides = new ArrayList<>(landStartTime.length + waterStartTime.length);
        for (int i = 0; i < landStartTime.length; i++) {
            landRides.add(new Ride(landStartTime[i], landDuration[i], RideType.LAND));
        }

        List<Ride> waterRides = new ArrayList<>(waterStartTime.length);
        for (int i = 0; i < waterDuration.length; i++) {
            waterRides.add(new Ride(waterStartTime[i], waterDuration[i], RideType.WATER));
        }

        int result = Integer.MAX_VALUE;
        for (Ride waterRide: waterRides){
            for (Ride landRide: landRides){
                int waterThenLand = getEndTime(waterRide, landRide);
                int landThenWater = getEndTime(landRide, waterRide);
                result = Math.min(result, Math.min(waterThenLand, landThenWater)) ;
            }
        }

        return result;
    }

    private static int getEndTime(Ride x, Ride y) {
        return x.finishTime() +
            (y.startTime() > x.finishTime() ? y.startTime() - x.finishTime() : 0)
            + y.duration();
    }
}
