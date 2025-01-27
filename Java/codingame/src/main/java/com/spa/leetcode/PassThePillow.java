package com.spa.leetcode;

public class PassThePillow {

    // https://leetcode.com/problems/pass-the-pillow/submissions/1418883192/
    public int passThePillow(int n, int time) {
        int pillowPosition = 1;
        int direction = 1;
        for (int i = 1; i <= time; i++) {
            pillowPosition += direction;
            if (pillowPosition == n || pillowPosition == 1) {
                direction = -1 * direction;
            }
        }
        return pillowPosition;
    }


    // https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/submissions/1418885461/
    public int numberOfChild(int n, int k) {
        int ballPosition = 0;
        int direction = 1;
        for (int i = 1; i <= k; i++) {
            ballPosition += direction;
            if (ballPosition == n - 1 || ballPosition == 0) {
                direction = -1 * direction;
            }
        }
        return ballPosition;
    }
}
