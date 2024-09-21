package com.spa.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    // https://leetcode.com/problems/destination-city/submissions/1397467990/
    public String destCity(List<List<String>> paths) {
        Set<String> departures = new HashSet<>();
        Set<String> arrivals = new HashSet<>();

        for(var path : paths){
            departures.add(path.get(0));
            arrivals.add(path.get(1));
        }
        arrivals.removeAll(departures);
        return arrivals.stream().findFirst().orElseThrow();
    }
}
