package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        while (true) {
            if (strs[0].isEmpty()) {// if the first element becomes empty
                return prefix.toString();
            }
            String firstCharacter = strs[0].substring(0, 1);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].isEmpty()) {
                    return prefix.toString();
                }
                if (!strs[i].substring(0, 1).equals(firstCharacter)) {
                    return prefix.toString();
                }

                strs[i] = strs[i].substring(1);

            }
            prefix.append(firstCharacter);
        }

    }

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int currentCustomerWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                currentCustomerWealth += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, currentCustomerWealth);
        }
        return maxWealth;
    }

    public int numberOfSteps(int num) {
        return num == 0 ? 0 : Integer.bitCount(num) + log2(num) - 1;
    }

    private int countSetBits(int n) {
        // https://www.geeksforgeeks.org/java-integer-bitcount-method/
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int log2(int x) {
        // https://www.techiedelight.com/calculate-log-base-2-integer-java/
        if (x <= 0) {
            throw new IllegalArgumentException("x (" + x + ") must be positive");
        }
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ListNode reverseHead = new ListNode(head.val);
        while (current.next != null) {
            current = current.next;
            ListNode newHead = new ListNode(current.val);
            newHead.next = reverseHead;
            reverseHead = newHead;
        }

        while (head.next != null) {
            if (head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    public int romanToInt(String s) {
        Map<String, Integer> bases = Map.ofEntries(
                Map.entry("X", 10), Map.entry("I", 1), Map.entry("V", 5), Map.entry("L", 50), Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000),
                Map.entry("IV", 4),
                Map.entry("IX", 9),
                Map.entry("XL", 40),
                Map.entry("XC", 90), Map.entry("CD", 400), Map.entry("CM", 900));

        int total = 0;
        while (!s.isEmpty()) {
            if (s.length() >= 2 && bases.containsKey(s.substring(0, 2))) {
                total += bases.get(s.substring(0, 2));
                s = s.substring(2);
            } else {
                total += bases.get(s.substring(0, 1));
                s = s.substring(1);
            }

        }

        return total;

    }

    /**
     * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
     * 
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat, int k) {

        // reduce the rows
        int[] result = new int[k];
        Row[] rows = new Row[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int soldiersCount = 0;
            for (int j = 0; j < mat[i].length; j++) {
                soldiersCount += mat[i][j];
            }
            rows[i] = new Row(i, soldiersCount);
        }

        Arrays.sort(rows,
                Comparator.<Row>comparingInt(row -> row.numberOfSoldiers).thenComparingInt(row -> row.rowIndex));

        for (int index = 0; index < k; index++) {
            result[index] = rows[index].rowIndex;
        }
        return result;
    }

    public record Row(int rowIndex, int numberOfSoldiers) {

    }

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            runningSum[index] = nums[index] + runningSum[index - 1];
        }
        return runningSum;
    }

}
