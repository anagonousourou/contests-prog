package com.spa.hackerrank;

public class HowManyGames {

    public static int howManyGames(int p, int d, int m, int s) {

        int currentPrice = p;
        int nbGames = 0;
        int cost = 0;
        while (cost < s){
            if(currentPrice == m && cost + m <= s){
                nbGames++;
                cost += m;

            }else if(cost + currentPrice <=s){
                nbGames++;
                cost += currentPrice;
            }else{
                break;
            }
            currentPrice = Math.max(currentPrice - d, m);

        }
        return nbGames;
    }

    public static void main(String[] args) {
        System.out.println("NbGames "+ howManyGames(20,3,6,80));
    }
}
