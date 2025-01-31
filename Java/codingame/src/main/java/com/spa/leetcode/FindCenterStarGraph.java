package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindCenterStarGraph {

    //https://leetcode.com/problems/find-center-of-star-graph/submissions/1232337780/
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> sommets = new HashMap<>(4);
        sommets.put(edges[0][0], 1);
        sommets.put(edges[0][1], 1);
        sommets.put(edges[1][0], sommets.getOrDefault(edges[1][0], 0) + 1);
        sommets.put(edges[1][1], sommets.getOrDefault(edges[1][1], 0) + 1);
        for (var entry : sommets.entrySet()){
            if(entry.getValue() == 2){
                return entry.getKey();
            }
        }
        return -1;
    }
}
