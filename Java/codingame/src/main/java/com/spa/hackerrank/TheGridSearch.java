package com.spa.hackerrank;

import java.util.List;

public class TheGridSearch {

    //NOT CORRECT YET
    public static String gridSearch(List<String> grid, List<String> pattern) {
        // Write your code here
        String patternRow = pattern.get(0);
        for (int i = 0; i < grid.size(); i++) {
            int patternPosition = grid.get(i).indexOf(patternRow);
            while (patternPosition != -1) {
                boolean found = true;
                for (int j = 1; j < pattern.size(); j++) {
                    if (i + j >= grid.size() || grid.get(i + j).indexOf(pattern.get(j)) != patternPosition) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return "YES";
                }

                patternPosition = grid.get(i).substring(patternPosition + 1).indexOf(patternRow);
                if(patternPosition == - 1){
                    break;
                }else{
                    patternPosition += grid.get(i).substring(0, patternPosition + 1).length();
                }
                System.out.println("PatternPosition " + patternPosition);
            }

        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println("Answer = "+ gridSearch(List.of("123412", "561212", "123634", "781288"), List.of("12", "34"))); ;
    }
}
