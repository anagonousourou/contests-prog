package com.spa.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    //https://leetcode.com/problems/number-of-provinces
    public int findCircleNum(int[][] isConnected) {
        boolean[] encountered = new boolean[isConnected.length];
        int nbProvinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!encountered[i]){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                encountered[i] = true;
                while (!queue.isEmpty()){
                    var v = queue.poll();

                    for (int neighbor = 0; neighbor < isConnected[v].length; neighbor++) {
                        if(isConnected[v][neighbor] == 1 && !encountered[neighbor]){
                            encountered[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
                nbProvinces++;
            }
        }

        return nbProvinces;
    }
}
