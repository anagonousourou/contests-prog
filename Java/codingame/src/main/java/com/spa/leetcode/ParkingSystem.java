package com.spa.leetcode;

public class ParkingSystem {

    //https://leetcode.com/problems/design-parking-system/
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {

        if (carType == 1 && big == 0) {
            return false;
        }
        if (carType == 2 && medium == 0) {
            return false;
        }
        if (carType == 3 && small == 0) {
            return false;
        }

        if (carType == 1) {
            big--;
            return true;
        }
        if (carType == 2) {
            medium--;
            return true;
        }
        if (carType == 3) {
            small--;
            return true;
        }
        return false;
    }
}
