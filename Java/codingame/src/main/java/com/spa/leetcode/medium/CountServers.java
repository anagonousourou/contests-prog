package com.spa.leetcode.medium;

import java.util.HashSet;
import java.util.Set;


// https://leetcode.com/problems/count-servers-that-communicate/submissions/2192028110/?envType=daily-question&envId=2026-11-08
public class CountServers {

    record Server(int i, int j) {
    }

    public int countServers(int[][] grid) {
        Set<Server> servers = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            Set<Server> currentServers = new HashSet<>();
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    currentServers.add(new Server(i, j));
                }
            }
            if (count > 1) {
                servers.addAll(currentServers);
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int count = 0;
            Set<Server> currentServers = new HashSet<>();
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    count++;
                    currentServers.add(new Server(i, j));
                }
            }
            if (count > 1) {
                servers.addAll(currentServers);
            }
        }
        return servers.size();
    }
}
