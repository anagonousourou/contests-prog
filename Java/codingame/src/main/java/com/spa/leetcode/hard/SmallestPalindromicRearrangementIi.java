package com.spa.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

public class SmallestPalindromicRearrangementIi {

    // https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/submissions/2086498035/

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        String half = s.substring(0, n / 2);
        char mid = (n % 2 == 1) ? s.charAt(n / 2) : 0;

        // Frequency map of the left half (TreeMap for lexicographic order)
        TreeMap<Character, Integer> freq = new TreeMap<>();
        for (char c : half.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }

        // Total permutations of the half, capped at k+1
        long total = boundedPermutations(freq, k);
        if (k <= 0 || k > total) {
            return "";
        }

        StringBuilder left = new StringBuilder();
        int remaining = half.length();

        for (int i = 0; i < half.length(); i++) {
            for (char c : freq.keySet()) {
                int cnt = freq.get(c);
                if (cnt == 0)
                    continue;

                // Temporarily use one 'c'
                freq.put(c, cnt - 1);
                long perms = boundedPermutations(freq, k);

                if (k > perms) {
                    // Target not in this branch, skip it
                    k -= perms;
                    freq.put(c, cnt); // restore
                } else {
                    // Found the correct character
                    left.append(c);
                    remaining--;
                    break; // move to next position
                }
            }
        }

        String leftStr = left.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();
        return (mid == 0) ? leftStr + rightStr
                : leftStr + mid + rightStr;
    }

    /**
     * Returns the number of distinct permutations of the current multiset,
     * capped at k+1.  Guarantees no overflow and correct comparison with k.
     */
    private long boundedPermutations(Map<Character, Integer> freq, int k) {
        int total = 0;
        for (int v : freq.values())
            total += v;
        if (total == 0)
            return 1;

        long res = 1;
        int remaining = total;

        for (int cnt : freq.values()) {
            if (cnt == 0)
                continue;
            // Multiply by C(remaining, cnt) with early cap
            res = res * boundedCombination(remaining, cnt, k + 1);
            if (res > k)
                return k + 1; // cap as soon as we exceed k
            remaining -= cnt;
        }
        return res;
    }

    /**
     * Computes C(n, r) but caps the result at `limit` (i.e., returns min(C(n,r), limit)).
     */
    private long boundedCombination(int n, int r, long limit) {
        if (r == 0 || r == n)
            return 1;
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > limit)
                return limit; // cap early
        }
        return res;
    }
}
