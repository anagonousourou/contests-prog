package com.spa.leetcode;

public class FindTheTownJudge {

    //https://leetcode.com/problems/find-the-town-judge/submissions/1182936936/?envType=daily-question&envId=2024-02-22
    public int findJudge(int n, int[][] trust) {
        //number of people who trust the person
        int[] people = new int[n + 1];
        //number of people the person trusts
        int[] trustedPeople = new int[n + 1];

        for (int[] pair : trust) {
            people[pair[1]]++;
            trustedPeople[pair[0]]++;
        }
        for (int i = 1; i < people.length; i++) {
            if (people[i] == n - 1 && trustedPeople[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
