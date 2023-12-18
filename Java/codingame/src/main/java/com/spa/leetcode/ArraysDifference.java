package com.spa.leetcode;

import java.util.*;


//https://leetcode.com/problems/find-the-difference-of-two-arrays/
public class ArraysDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var nums1List = Arrays.stream(nums1).boxed().toList();
        var nums2List = Arrays.stream(nums2).boxed().toList();

        Set<Integer> nums1Set = new HashSet<>(nums1List);
        nums1Set.removeAll(nums2List);

        Set<Integer> nums2Set = new HashSet<>(nums2List);
        nums2Set.removeAll(nums1List);

        List<List<Integer>> result = new ArrayList<>(2);
        result.add(new ArrayList<>(nums1Set));
        result.add(new ArrayList<>(nums2Set));
        return result;
    }
}
