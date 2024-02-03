package com.spa.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://www.hackerrank.com/challenges/minimum-distances/problem
public class MinimumDistances {

    static class Pair{
        int minIndex;
        int maxIndex;

        public Pair(int minIndex, int maxIndex) {
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
        }
    }

    public static int minimumDistances(List<Integer> a) {
        Map<Integer, Pair> distances = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            if(distances.containsKey(a.get(i))){
                distances.get(a.get(i)).maxIndex = i;
            }else{
                distances.put(a.get(i), new Pair(i, i));
            }
        }
        return distances.values().stream().filter(pair -> pair.maxIndex != pair.minIndex)
            .mapToInt(pair -> pair.maxIndex - pair.minIndex).min().orElse(-1);
    }
}
