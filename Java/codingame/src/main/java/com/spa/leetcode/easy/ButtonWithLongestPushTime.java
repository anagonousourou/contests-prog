package com.spa.leetcode.easy;

public class ButtonWithLongestPushTime {

    // https://leetcode.com/problems/button-with-longest-push-time/submissions/1698505292/

    public int buttonWithLongestTime(int[][] events) {
        int button = events[0][0];
        int maxPushTime = events[0][1];
        for (int i = 1; i < events.length; i++) {
            if(events[i][1] - events[i - 1][1] > maxPushTime){
                maxPushTime = events[i][1] - events[i - 1][1];
                button = events[i][0];
            }
            else if(events[i][1] - events[i - 1][1] == maxPushTime  && button > events[i][0]){
                button = events[i][0];
            }
        }
        return button;
    }
}
