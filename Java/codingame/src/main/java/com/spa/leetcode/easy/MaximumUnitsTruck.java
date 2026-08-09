package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsTruck {

    // https://leetcode.com/problems/maximum-units-on-a-truck/submissions/2098679608/
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,  Comparator.comparingInt(boxType -> boxType[1]));
        int units = 0;
        int i = 0;
        while (!(truckSize <= 0 || i >=  boxTypes.length)){
            if(truckSize > boxTypes[i][0]) {
                units += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }else{
                units+= boxTypes[i][1] * truckSize;
                truckSize = 0;
            }
            System.out.println(truckSize);
            i++;
        }
        return units;
    }
}
