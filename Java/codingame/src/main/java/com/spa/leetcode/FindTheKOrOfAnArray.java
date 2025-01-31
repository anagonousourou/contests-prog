package com.spa.leetcode;

import java.util.Arrays;
import java.util.List;

public class FindTheKOrOfAnArray {

    //https://leetcode.com/problems/find-the-k-or-of-an-array/submissions/1204990499/
    public int findKOr(int[] nums, int k) {
        List<String> numsBinaryReps = Arrays.stream(nums).mapToObj(Integer::toBinaryString).map(s -> "0".repeat(31 - s.length()) + s)
            .toList();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int count1 = 0;
            for (int j = 0; j < nums.length; j++) {
                if(numsBinaryReps.get(j).charAt(i) == '1'){
                    count1++;
                }
            }
            if(count1 >= k){
                result.append("1");
            }else{
                result.append("0");
            }
        }
        return Integer.parseInt(result.toString(), 2);
    }
}
