package com.spa.leetcode.medium;

import java.util.*;

public class CountCompleteComponents {


    // https://leetcode.com/problems/count-the-number-of-complete-components/submissions/1582250732/?envType=daily-question&envId=2025-03-22
    public int countCompleteComponents(int n, int[][] edges) {

        // build the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (var edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // find all the connected components
        Set<Set<Integer>> components = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int finalI = i;
            if (components.stream().noneMatch(component -> component.contains(finalI))) {
                Set<Integer> component = new HashSet<>();
                bfs(i, component, graph);
                components.add(component);
            }
        }

        // filter the ones that are complete
        return (int) components.stream().filter(component -> component.stream().allMatch(vertex -> {
            var tmp = new HashSet<>(graph.get(vertex));
            tmp.add(vertex);
            return tmp.equals(component);
        })).count();
    }

    void bfs(int s, Set<Integer> visited, Map<Integer, Set<Integer>> graph) {
        // Create a queue for BFS
        Deque<Integer> queue
            = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited.add(s);
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            // Get all adjacent vertices of the dequeued
            // vertex s.
            // If an adjacent has not been visited,
            // then mark it visited and enqueue it
            for (int n : graph.get(s)) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
    }
}
