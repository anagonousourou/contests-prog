package com.spa.leetcode;

public class NimGame {

    public boolean canWinNim(int n) {
        return canWinNim(n, true);
    }

    public boolean canWinNim(int n, boolean myturn) {
        if(n == 6 && myturn){
            return true;
        }
        if(n <= 3 && myturn){
            return true;
        }
        else if(n <= 3 && !myturn){
            return false;
        }
        else{
            if(n -1 <= 3){
                return !myturn;
            }

            return canWinNim(n - 1, !myturn);
        }
    }
}
