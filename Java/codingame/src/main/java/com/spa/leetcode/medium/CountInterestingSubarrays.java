package com.spa.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountInterestingSubarrays {


    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] prefix = new int[nums.size() + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }

        long count = 0;

        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                if ((prefix[j] - prefix[i]) % modulo == k) {
                    count++;
                }
            }
        }

        return count;
    }


    // https://leetcode.com/problems/count-of-interesting-subarrays/submissions/1617509282/?envType=daily-question&envId=2025-04-25
    public long countInterestingSubarrays1(List<Integer> nums, int modulo, int k) {
        // Create a prefix sum array to store the cumulative remainder counts
        int[] prefix = new int[nums.size() + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }

        // Use a hash map to store the counts of remainders
        Map<Integer, Integer> remainderCount = new HashMap<>();
        long count = 0;

        for (int i = 0; i < prefix.length; i++) {
            int currentRemainder = prefix[i] % modulo;
            // Check if there is a complement remainder that satisfies the condition
            int complementRemainder = (currentRemainder - k + modulo) % modulo;
            count += remainderCount.getOrDefault(complementRemainder, 0);
            // Update the count of current remainder in the hash map
            remainderCount.put(currentRemainder, remainderCount.getOrDefault(currentRemainder, 0) + 1);
        }

        return count;
    }

}
