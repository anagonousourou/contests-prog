package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteSubArray {

    // https://leetcode.com/problems/count-complete-subarrays-in-an-array/submissions/1616747034/?envType=daily-question&envId=2025-04-24
    public int countCompleteSubarrays(int[] nums) {
        List<int[]> occs = new ArrayList<>(nums.length + 1);

        int[] currentOccs = new int[2001];
        occs.add(new int[2001]);
        int totalDistinct = 0;
        for (int num : nums) {
            if (currentOccs[num] == 0) {
                totalDistinct++;
            }
            currentOccs[num] += 1;
            occs.add(currentOccs.clone());
        }

        int count = 0;
        for (int i = 0; i < occs.size(); i++) {
            for (int j = i + totalDistinct; j < occs.size(); j++) {
                if (findDistinct(occs.get(i), occs.get(j)) == totalDistinct) {
                    count += (occs.size() - j);
                    break;
                }
            }
        }

        return count;
    }

    int findDistinct(int[] first, int[] second) {
        int count = 0;

        for (int i = 0; i < second.length; i++) {
            if (second[i] - first[i] > 0) {
                count++;
            }
        }
        return count;
    }

}
