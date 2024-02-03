package com.spa.leetcode;

public class CanPlaceFlowers {

    //https://leetcode.com/problems/can-place-flowers/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int addedFlowers = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && ((i - 1 >= 0 && flowerbed[i - 1] == 0) || i == 0) && ((i + 1 < flowerbed.length && flowerbed[i + 1] == 0) || i + 1 == flowerbed.length)) {
                flowerbed[i] = 1;
                addedFlowers++;
            }
        }
        return addedFlowers >= n;
    }
}
