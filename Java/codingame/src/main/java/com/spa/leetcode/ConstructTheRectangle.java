package com.spa.leetcode;

public class ConstructTheRectangle {

    //https://leetcode.com/problems/construct-the-rectangle/submissions/1204254730/
    public int[] constructRectangle(int area) {
        double x = Math.sqrt(area);
        if(x == Math.rint(x)){
            return new int[]{(int)x, (int)x};
        }
        else{
            int xint = (int)x;
            for (int i = xint - 1; i >= 1; i--) {
                if(area % i == 0){
                    int side2 = area / i;
                    return new int[]{Math.max(side2, i), Math.min(side2, i)};
                }
            }
        }
        return null;
    }
}
