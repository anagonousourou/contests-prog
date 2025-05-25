package com.spa.leetcode.medium;


public class PushDominoes {

    //https://leetcode.com/problems/push-dominoes/submissions/1623406231/?envType=daily-question&envId=2025-05-02
    public String pushDominoes(String dominoes) {
        int[] directions = new int[dominoes.length()];

        int time = 0;
        char direction = '.';
        for (int i = 0; i < directions.length; i++) {
            if(dominoes.charAt(i) == 'L') {
                directions[i] = Integer.MIN_VALUE;
                direction = 'L';
                time = 0;
            }else if(dominoes.charAt(i) == 'R'){
                directions[i] = Integer.MAX_VALUE;
                direction = 'R';
                time = 0;
            }
            else{
                 if (direction == 'R') {
                    directions[i] += 100_000 - time;
                    time++;
                }
            }
        }

        time = 0;
        direction = '.';
        for (int i = directions.length - 1; i >= 0; i--) {
            if(dominoes.charAt(i) == 'L') {
                directions[i] = Integer.MIN_VALUE;
                direction = 'L';
                time = 0;
            }else if(dominoes.charAt(i) == 'R'){
                directions[i] = Integer.MAX_VALUE;
                direction = 'R';
                time = 0;
            }
            else{
                if(direction == 'L'){
                    directions[i] += - 100_000 +  time;
                    time++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : directions){
            if(i == 0){
                stringBuilder.append(".");
            }
            else if(i > 0){
                stringBuilder.append("R");
            }
            else {
                stringBuilder.append("L");
            }
        }
        return stringBuilder.toString();
    }
}
