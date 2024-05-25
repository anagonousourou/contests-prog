package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> cash = new HashMap<>();
        cash.put(5, 0);
        cash.put(10, 0);
        cash.put(20, 0);
        for(int bill : bills){
            if(bill == 5){
                cash.put(5, cash.get(5) + 1);
            }
            else if(bill == 10 && cash.get(5) >= 1){
                cash.put(10, cash.get(10) + 1);
                cash.put(5, cash.get(5) - 1);
            }
            else if(bill == 20 && cash.get(5) >= 1 && cash.get(10) >= 1){
                cash.put(20, cash.get(20) + 1);
                cash.put(10, cash.get(10) - 1);
                cash.put(5, cash.get(5) - 1);
            }
            else if(bill == 20 && cash.get(5) >= 3 ){
                cash.put(20, cash.get(20) + 1);
                cash.put(5, cash.get(5) - 3);
            }else{
                return false;
            }
        }
        return true;
    }
}
