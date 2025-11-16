package com.spa.leetcode.easy;

import com.spa.leetcode.ListNode;

public class GetDecimalValue {

    // https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/1618222908/
    public int getDecimalValue(ListNode head) {
        StringBuilder binaryRepresentation = new StringBuilder();

        while (head != null){
            binaryRepresentation.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(binaryRepresentation.toString(), 2);
    }
}
