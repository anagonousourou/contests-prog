package com.spa.leetcode;

public class AccountBalanceAfterPurchase {

    //https://leetcode.com/problems/account-balance-after-rounded-purchase/submissions/1195012847/
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int distance = purchaseAmount % 10;
        if(distance < 5){
            return 100 - (purchaseAmount - distance);
        }else{
            return 100 - (purchaseAmount + (10 - distance));
        }
    }
}
