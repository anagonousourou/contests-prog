package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {

    //https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/1229789732/?envType=daily-question&envId=2024-03-25

    /**
     * To tackle this problem, consider the constraints and what they imply for your approach:
     *
     * •  O(n) Time: This means you should be able to find the solution in a single pass through the array.
     *
     * •  Constant Space: You can't use any additional data structures that grow with the size of the input.
     *
     * With these constraints in mind, think about how you can utilize the properties of the input array to track duplicates. Since the numbers are all in the range from 1 to n, you might find a way to flag an integer that has already been seen directly within the original array.
     *
     * Here's a hint: Try to think of a way to use the indices of the array to your advantage. Can you modify the array in-place in such a way that you can later identify which numbers have appeared more than once?
     *
     * Reflect on the relationships between the elements and their indices, and how altering the array during your single pass could help you identify duplicates without needing extra space.
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Step "+ i +" " + Arrays.toString(nums));
            if(nums[i] - 1 != i){
                int tmp = nums[nums[i] - 1];
                if(tmp == nums[i]){
                    duplicates.add(tmp);
                }else{
                    int position = nums[i] - 1;
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                    if(position > i){
                        i--;
                    }
                }
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        System.out.println("Result = "+ findDuplicates.findDuplicates(new int[]{5,4,6,7,9,3,10,9,5,6}));
        System.out.println("\n\n***\n");
        System.out.println("Result = "+ findDuplicates.findDuplicates(new int[]{1,1,2}));
    }
}
