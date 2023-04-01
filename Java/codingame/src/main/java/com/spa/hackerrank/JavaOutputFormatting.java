package com.spa.hackerrank;

import java.util.Scanner;

public class JavaOutputFormatting {


    /**
     * http://stackoverflow.com/questions/388461/ddg#391978
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-14s %03d\n", s1, x);
        }
        System.out.println("================================");

    }

    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }
}
