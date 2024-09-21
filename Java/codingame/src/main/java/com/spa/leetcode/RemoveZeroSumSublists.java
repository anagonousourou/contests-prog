package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublists {


    //https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/submissions/1201911182/?envType=daily-question&envId=2024-03-12

    /**
     * We use some prefix sums of the elements that we meet and a Map of prefixSum and their corresponding ListNode (latest element summed)
     * We also have a reverse Map to ease the deletion of the prefix sums knowing their ListNode.
     * The idea is that: when we do a prefix sum, whenever we reach 0 it means we could give up every element encountered until now without any consequence on the final sum
     * And whenever we encounter a sum that we have already done it means that every value encountered between the previous same sum and now
     * sum up to 0 and can be discarded.
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        Map<Integer, ListNode> nodeByPrefixSum = new HashMap<>();
        Map<ListNode, Integer> prefixSumByNode = new HashMap<>();
        ListNode current = head;
        while (current != null){
            sum += current.val;
            if(sum == 0){
                nodeByPrefixSum.clear();
                prefixSumByNode.clear();
                head = current.next;
            }
            else if(nodeByPrefixSum.containsKey(sum)){
                ListNode toDelete = nodeByPrefixSum.get(sum).next;
                while (toDelete != current){
                    nodeByPrefixSum.remove(prefixSumByNode.get(toDelete));
                    prefixSumByNode.remove(toDelete);

                    toDelete = toDelete.next;
                }
                nodeByPrefixSum.get(sum).next = current.next;

            }else{
                nodeByPrefixSum.put(sum, current);
                prefixSumByNode.put(current, sum);
            }
            current = current.next;
        }

        return head;
    }
}
