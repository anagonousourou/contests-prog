package com.spa.leetcode;

public class TimeNeededToBuyTickets {

    //https://leetcode.com/problems/time-needed-to-buy-tickets/submissions/1227547174/?envType=daily-question&envId=2024-04-09
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTime = 0;
        for (int i = 0; i < k; i++) {
            totalTime += Math.min(tickets[i], tickets[k]);
        }
        for (int i = k + 1; i < tickets.length; i++) {
            totalTime += Math.min(tickets[i], tickets[k] - 1);
        }
        return totalTime + tickets[k];
    }
}
