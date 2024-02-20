package com.spa.leetcode;

public class BusyStudent {

    //https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/submissions/1179663644/
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int nb = 0;
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i] <= queryTime && queryTime <= endTime[i]){
                nb++;
            }
        }
        return nb;
    }
}
