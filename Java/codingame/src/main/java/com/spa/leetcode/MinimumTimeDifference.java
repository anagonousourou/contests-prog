package com.spa.leetcode;

import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {

    //TODO
    record Time(int hour, int minutes) {
    }

    public int findMinDifference(List<String> timePoints) {
        var times = timePoints.stream().map(p -> {
                var parts = p.split(":");
                return new Time(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            }).sorted(Comparator.comparingInt(Time::hour).thenComparing(Time::minutes))
            .toList();

        for (int i = 0; i < times.size(); i++) {

        }
        return 0;
    }
    //t1 is smaller than t2
    private static int diff(Time t1, Time t2){
        return 0;
        /*if(t1.hour == t2.hour){
            return 60 - t1.minutes + t2.minutes;
        }
        else{
            int result = 60 - t1.minutes + t2.minutes;
            return diff(new Time(t1.hour + 1), ))
        }*/
    }
}
