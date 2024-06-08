package com.spa.leetcode;


// https://leetcode.com/problems/kth-largest-element-in-a-stream/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/*

KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    kthLargest.add(3);   // return 4
    kthLargest.add(5);   // return 5
    kthLargest.add(10);  // return 5
    kthLargest.add(9);   // return 8
    kthLargest.add(4);   // return 8
2, 3, 4, 5, 8
2, 3, 4, 5, 5, 8
2, 3, 4, 5, 5, 8, 10
2, 3, 4, 5, 5, 8, 9, 10


 */


// https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/1281330235/

// other option : use https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
public class KthLargest {
    private final int k;
    private final List<Integer> nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toCollection(() -> new ArrayList<>(10_000)));
        Collections.sort(this.nums);
    }

    public int add(int val) {
        if((nums.size() == 0) || val >= nums.get(nums.size() - 1)){
            nums.add(val);
        }
        else{
            for (int i = 0; i < nums.size(); i++) {
                if(nums.get(i) >= val){
                    nums.add(i, val);
                    break;
                }
            }
        }

        return nums.get(nums.size() - k);
    }
}
