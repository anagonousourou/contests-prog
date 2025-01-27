package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PickGifts {


    // https://leetcode.com/problems/take-gifts-from-the-richest-pile/submissions/1430204813/
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        long initialTotalGift = 0;
        long takenGift = 0;
        for (int gift : gifts) {
            queue.add(gift);
            initialTotalGift += gift;
        }

        for (int i = 0; i < k; i++) {
            int maxGift = queue.poll();
            if (maxGift == 1) {
                break;
            }
            int leaveBehind = (int) Math.sqrt(maxGift);
            takenGift += (maxGift - leaveBehind);
            queue.offer(leaveBehind);
        }
        return initialTotalGift - takenGift;
    }

    // https://leetcode.com/problems/take-gifts-from-the-richest-pile/submissions/1430196896/
    public long pickGifts1(int[] gifts, int k) {
        for (int i = 0; i < k; i++) {
            int maxIdx = maxIndex(gifts);
            if (gifts[maxIdx] == 1) {
                break;
            }
            gifts[maxIdx] = (int) Math.sqrt(gifts[maxIdx]);
        }
        return Arrays.stream(gifts).mapToLong(i -> (long) i).sum();
    }

    int maxIndex(int[] gifts) {
        int currentMaxIndex = 0;
        for (int i = 1; i < gifts.length; i++) {
            if (gifts[i] > gifts[currentMaxIndex]) {
                currentMaxIndex = i;
            }
        }
        return currentMaxIndex;
    }
}
