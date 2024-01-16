package com.spa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KeysAndRooms {

    //https://leetcode.com/problems/keys-and-rooms/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> encountered = new HashSet<>();
        queue.add(0);
        encountered.add(0);
        while (!queue.isEmpty()){
            var v = queue.poll();

            for(var neighbor : rooms.get(v)){
                if(!encountered.contains(neighbor)){
                    encountered.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return encountered.size() == rooms.size();
    }
}
