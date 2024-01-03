package com.spa.leetcode;

import java.util.Arrays;
import java.util.List;

public class NumberOfLaserBeamsInBank {


    //https://leetcode.com/problems/number-of-laser-beams-in-a-bank/submissions/
    public int numberOfBeams(String[] bank) {

        List<String> rowsWithDevices = Arrays.stream(bank).filter(s -> s.contains("1")).toList();
        if(rowsWithDevices.isEmpty()){
            return 0;
        }

        int nbLasers = 0;
        int nbCurrentDevices = nbDeviceInRow(rowsWithDevices.get(0));
        for (int i = 1; i < rowsWithDevices.size(); i++) {
            int nbNextDevice = nbDeviceInRow(rowsWithDevices.get(i));
            nbLasers += nbCurrentDevices * nbNextDevice;
            nbCurrentDevices = nbNextDevice;
        }
        return nbLasers;
    }

    private int nbDeviceInRow(String row){
        return (int) row.chars().mapToObj(c -> (char)c).filter(c -> c == '1')
            .count();
    }
}
