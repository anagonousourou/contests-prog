package com.spa.leetcode;

public class CountOperations {

    //https://leetcode.com/problems/count-operations-to-obtain-zero/submissions/1174242823/
    public int countOperations(int num1, int num2) {
        if (num2 == 0 || num1 == 0) {
            return 0;
        } else if (num2 >= num1) {
            return (num2 / num1) + countOperations(num2 % num1, num1);
        } else {
            return (num1 / num2) + countOperations(num1 % num2, num2);
        }
    }
}
