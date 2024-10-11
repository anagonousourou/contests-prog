package com.spa.leetcode;

public class CountTestedDevices {

    // https://leetcode.com/problems/count-tested-devices-after-test-operations/submissions/1418791371/
    public int countTestedDevices(int[] batteryPercentages) {
        int counter = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (Math.max(batteryPercentage - counter, 0) > 0) {
                counter++;
            }
        }
        return counter;
    }
}
