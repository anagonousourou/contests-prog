package com.spa.leetcode.medium;

import com.spa.leetcode.ListNode;

public class DeleteNodeInALinkedList {

    //https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/1179714622/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
