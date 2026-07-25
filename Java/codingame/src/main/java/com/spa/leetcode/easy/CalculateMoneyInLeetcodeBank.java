package com.spa.leetcode.easy;

/**
 * CalculateMoneyInLeetcodeBank
 */
public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int remainingDays = n % 7;
        int lastWeek = fullWeeks + 1;
        int sum = 0;
        for (int i = 0; i < fullWeeks; i++) {
            sum += (49 * i) / 2;
        }
        System.out.println(sum);
        return sum + (( lastWeek + lastWeek + remainingDays - 1) * remainingDays) / 2;
    }
}
