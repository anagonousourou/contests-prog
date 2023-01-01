package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SolutionLeetCode {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int climbStairs1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs(int n) {
        Map<Integer, Set<String>> known = new HashMap<>(
                Map.of(1, Set.of("1"), 2, Set.of("11", "2"), 3, Set.of("111", "21", "12")));
        climbStairs1Utils(n, 4, known);
        return known.get(n).size();
    }

    public void climbStairs1Utils(int n, int i, Map<Integer, Set<String>> known) {
        if (known.containsKey(i)) {
            return;
        }
        if (i <= n) {
            Set<String> ways = new HashSet<>();
            ways.addAll(known.get(i - 1).stream().map(seq -> seq + "1").collect(Collectors.toSet()));
            ways.addAll(known.get(i - 1).stream().map(seq -> "1" + seq).collect(Collectors.toSet()));
            ways.addAll(known.get(i - 2).stream().map(seq -> "2" + seq).collect(Collectors.toSet()));
            ways.addAll(known.get(i - 2).stream().map(seq -> seq + "2").collect(Collectors.toSet()));
            known.put(i, ways);
            climbStairs1Utils(n, i + 1, known);
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (int index = 1; index <= n; index++) {
            if (index % 15 == 0) {
                result.add("FizzBuzz");
            } else if (index % 5 == 0) {
                result.add("Buzz");
            } else if (index % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(index));
            }
        }

        return result;
    }

    public ListNode middleNode(ListNode head) {

        ListNode current = head;
        int size = 0;
        do {
            size++;
            current = current.next;
        } while (current != null);
        int middle = size / 2;
        int i = 0;
        while(i < middle){
            head = head.next;
            i++;
        }
        return head;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCounts = new int[26];
        Arrays.fill(magazineCounts, 0);
        int[] ransomNoteCounts = new int[26];
        Arrays.fill(ransomNoteCounts, 0);

        int[] magazineAsInts = magazine.chars().map(c -> c - 97).toArray();
        int[] ransomNoteAsInts = ransomNote.chars().map(c -> c - 97).toArray();

        for (int magazineLetter : magazineAsInts) {
            magazineCounts[magazineLetter]++;
        }

        for (int ransomLetter : ransomNoteAsInts) {
            ransomNoteCounts[ransomLetter]++;
        }

        for (int i = 0; i < ransomNoteCounts.length; i++) {
            if (magazineCounts[i] < ransomNoteCounts[i]) {
                return false;
            }
        }

        return true;
    }

    public int numberOfSteps1(int num) {

        Map<Integer, Integer> known = new HashMap<>(Map.of(1, 1, 2, 2, 3, 3, 4, 3));
        if (known.containsKey(num)) {
            return known.get(num);
        } else if (num % 2 == 0) {
            return 1 + numberOfSteps(num / 2);
        } else if (num % 2 == 1) {
            return 1 + numberOfSteps(num - 1);
        }
        return 0;

    }

    public int numberOfSteps(int num) {

        Map<Integer, Integer> known = new HashMap<>(Map.of(1, 1, 2, 2, 3, 3, 4, 3));
        if (known.containsKey(num)) {
            return known.get(num);
        } else if (num % 2 == 0) {
            return 1 + numberOfSteps(num / 2);
        } else if (num % 2 == 1) {
            return 1 + numberOfSteps(num - 1);
        }
        return 0;

    }

    /**
     * https://leetcode.com/problems/find-pivot-index/
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        // reduce l-to-r

        int[] lr = new int[nums.length];
        int[] rl = new int[nums.length];

        for (int index = 1; index < nums.length; index++) {
            lr[index] = lr[index - 1] + nums[index - 1];

        }
        rl[nums.length - 1] = 0;
        for (int index = nums.length - 2; index >= 0; index--) {
            rl[index] = rl[index + 1] + nums[index + 1];
        }

        for (int index = 0; index < nums.length; index++) {
            if (rl[index] == lr[index]) {
                return index;
            }
        }

        return -1;
    }

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic(s, t, new HashMap<>());
    }

    public boolean isIsomorphic(String s, String t, Map<String, String> transformations) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        String currentSLetter = s.substring(0, 1);
        String currentTLetter = t.substring(0, 1);

        if (transformations.containsKey(currentSLetter)
                && !transformations.get(currentSLetter).equals(currentTLetter)) {
            return false;
        }

        if (!transformations.containsKey(currentSLetter) && !transformations.containsValue(currentTLetter)) {
            transformations.put(currentSLetter, currentTLetter);
        }
        if (!transformations.containsKey(currentSLetter) && transformations.containsValue(currentTLetter)) {
            return false;
        }
        return isIsomorphic(s.substring(1), t.substring(1), transformations);
    }

    public boolean isSubsequence(String s, String t) {
        if (t.isEmpty() && !s.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        if (s.substring(0, 1).equals(t.substring(0, 1))) {
            return isSubsequence(s.substring(1), t.substring(1));
        }
        if (!s.substring(0, 1).equals(t.substring(0, 1))) {
            return isSubsequence(s, t.substring(1));
        }

        return false;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list2 == null && list1 != null) {
            return list1;
        }

        return mergeTwoListsImpl(list1, list2, null, null);
    }

    public ListNode mergeTwoListsImpl(ListNode list1, ListNode list2, ListNode currentNodeInResult,
            ListNode resultHead) {
        if (list1 == null && list2 == null) {
            return resultHead;
        }
        if (list1 == null) {
            currentNodeInResult.next = list2;
            return resultHead;
        }
        if (list2 == null) {
            currentNodeInResult.next = list1;
            return resultHead;
        }

        if (list1.val <= list2.val) {
            ListNode nextList1;
            if (resultHead == null) {
                currentNodeInResult = list1;
                nextList1 = list1.next;
                currentNodeInResult.next = null;
                resultHead = currentNodeInResult;
            } else {
                currentNodeInResult.next = list1;
                nextList1 = list1.next;
                currentNodeInResult.next.next = null;
                currentNodeInResult = currentNodeInResult.next;
            }

            return mergeTwoListsImpl(nextList1, list2, currentNodeInResult, resultHead);
        } else {
            ListNode nextList2;
            if (currentNodeInResult == null) {
                currentNodeInResult = list2;
                nextList2 = list2.next;
                currentNodeInResult.next = null;
                resultHead = currentNodeInResult;
            } else {
                currentNodeInResult.next = list2;
                nextList2 = list2.next;
                currentNodeInResult.next.next = null;
                currentNodeInResult = currentNodeInResult.next;
            }
            return mergeTwoListsImpl(list1, nextList2, currentNodeInResult, resultHead);
        }

    }

    public ListNode reverseList(ListNode head) {
        // 1 -> 7 -> 3 ->
        // <-1 , 7 -> 3 ->
        // <- 1 <- 7, 3 ->

        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode resultHead) {
        // 1 -> 7 -> 3 ->
        // <-1 , 7 -> 3 ->
        // <- 1 <- 7, 3 ->

        if (head == null) {
            return resultHead;
        }

        if (resultHead == null) {
            ListNode newInitialHead = head.next;
            head.next = null;
            return reverseList(newInitialHead, head);
        }

        ListNode newInitialHead = head.next;
        head.next = resultHead;
        return reverseList(newInitialHead, head);
    }

}
