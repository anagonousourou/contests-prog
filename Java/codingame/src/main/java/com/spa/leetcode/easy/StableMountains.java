package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class StableMountains {

    // https://leetcode.com/problems/find-indices-of-stable-mountains/submissions/1619141392/
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>(height.length);

        for (int i = 1; i < height.length; i++) {
            if(height[i - 1] > threshold){
                result.add(i);
            }
        }
        return result;
    }
}
