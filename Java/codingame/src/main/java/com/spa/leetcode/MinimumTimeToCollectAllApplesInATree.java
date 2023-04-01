package com.spa.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumTimeToCollectAllApplesInATree {

    record Vertex(int number, boolean hasApple){}

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Vertex, Vertex> tree = new HashMap<>();
        Set<Vertex> verticesWithApples = new HashSet<>();
        Vertex root = null;
        for (int i = 0; i < edges.length; i++) {

            Vertex from = new Vertex(edges[i][0], hasApple.get(edges[i][0]) );
            Vertex to = new Vertex(edges[i][1], hasApple.get(edges[i][1]) );

            if(tree.containsKey(to)){
                tree.put(from, to);
            }
            else{
                tree.put(to, from);
            }

            if(from.number() == 0){
                root = from;
            }
            if(to.number() == 0){
                root = to;
            }
            if(from.hasApple){
                verticesWithApples.add(from);
            }
            if(to.hasApple){
                verticesWithApples.add(to);
            }
        }
        List<List<Vertex>> allPaths = findAllShortestPathsFromApples(tree, root, verticesWithApples);
        int nbVertices = allPaths.stream().flatMap(Collection::stream).collect(Collectors.toSet()).size();
        if(nbVertices == 0){
            return  0;
        }
        return (nbVertices - 1) * 2;
    }

    public List<List<Vertex>> findAllShortestPathsFromApples(Map<Vertex, Vertex> tree, Vertex root,
                                                             Set<Vertex> verticesWithApples){
        List<List<Vertex>> allPaths = new ArrayList<>(verticesWithApples.size());
        for (Vertex appleVertex: verticesWithApples) {
            List<Vertex> path = new ArrayList<>();
            findShortestPathFromApple(tree, root, appleVertex, path);
            allPaths.add(path);
        }
        return allPaths;
    }

    public void findShortestPathFromApple(Map<Vertex, Vertex> tree, Vertex root, Vertex apple, List<Vertex> currentPath){
        if(apple.equals(root)){
            currentPath.add(root);
            return;
        }
        currentPath.add(apple);
        findShortestPathFromApple(tree, root, tree.get(apple), currentPath);
    }
}
