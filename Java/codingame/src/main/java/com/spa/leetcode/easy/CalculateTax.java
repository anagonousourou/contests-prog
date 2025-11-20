package com.spa.leetcode.easy;

public class CalculateTax {

    // https://leetcode.com/problems/calculate-amount-paid-in-taxes/submissions/1806593558/
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        for (int i = 0; i < brackets.length; i++) {
            int taxed = Math.min(brackets[i][0] - (i -1 == -1 ? 0 : brackets[i - 1][0]), income);
            tax += taxed * (brackets[i][1] / 100.0);
            income = Math.max(income - taxed, 0);
        }
        return tax;
    }
}
