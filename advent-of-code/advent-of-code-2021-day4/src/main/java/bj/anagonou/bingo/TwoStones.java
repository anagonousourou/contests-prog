package bj.anagonou.bingo;

import java.util.Scanner;

public class TwoStones{
    public static void main(String... args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n % 2 == 1){
            System.out.println("Alice");
        }
        else{
            System.out.println("Bob");
        }
        s.close();
    }
}
