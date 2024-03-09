package com.spa.leetcode;

public class MinimumLengthAfterDeletingSimilarEnds {

    //https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/submissions/1194944734/
    public int minimumLength(String s) {
        int front = 0;
        int back = s.length() - 1;

        int reduction = 0;

        while (front < back  && s.charAt(front)  == s.charAt(back)){
            while (front < back && s.charAt(front) == s.charAt(back)){
                front++;
                reduction++;
            }

            do{
                back--;
                reduction++;
            } while (front < back && s.charAt(back) == s.charAt(front - 1));
        }

        return s.length() - reduction;
    }

    public static void main(String[] args) {
        var solution  = new MinimumLengthAfterDeletingSimilarEnds();

        System.out.println(solution.minimumLength("cabaabac"));
    }
}
