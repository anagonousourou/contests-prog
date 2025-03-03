package com.spa.leetcode.easy;

public class StoneRemovalGame {


    // https://leetcode.com/problems/stone-removal-game/submissions/1561288106/
    public boolean canAliceWin(int n) {

        boolean aliceTurn = true;
        int toTake = 10;

        while (true){
            if(toTake > n){
                return !aliceTurn;
            }
            n -= toTake;
            aliceTurn = ! aliceTurn;
            toTake--;
        }
    }
}
