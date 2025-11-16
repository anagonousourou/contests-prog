package com.spa.leetcode.easy;

public class Tribonacci {

    // https://leetcode.com/problems/n-th-tribonacci-number/submissions/1624247871/

    int[] cache = new int[37];

    Tribonacci(){
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
    }
    public int tribonacci(int n) {
        if(n <= 2){
            return cache[n];
        }
        else{
           if(cache[n] == 0){
               int p1 = tribonacci(n - 1);
               cache[n - 1] = p1;

               int p2 = tribonacci(n - 2);
               cache[n - 2] = p2;

               int p3 = tribonacci(n - 3);
               cache[n - 3] = p3;
               return  p1 + p2 + p3;
           }else{
               return cache[n];
           }
        }
    }
}
