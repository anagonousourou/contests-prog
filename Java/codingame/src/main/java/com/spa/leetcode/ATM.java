package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    private final Map<Integer, Integer> banknotes = new HashMap<>();

    public ATM() {
        banknotes.put(20, 0);
        banknotes.put(50, 0);
        banknotes.put(100, 0);
        banknotes.put(200, 0);
        banknotes.put(500, 0);
    }


    public void deposit(int[] banknotesCount) {
        this.banknotes.merge(20, banknotesCount[0], Integer::sum);
        this.banknotes.merge(50, banknotesCount[1], Integer::sum);
        this.banknotes.merge(100, banknotesCount[2], Integer::sum);
        this.banknotes.merge(200, banknotesCount[3], Integer::sum);
        this.banknotes.merge(500, banknotesCount[4], Integer::sum);
    }

    public int[] withdraw(int amount) {
        return new int[0];
    }
}
