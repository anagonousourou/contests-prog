package com.spa.isograd;

import java.util.Scanner;

public class Prehistoire {
    public static void main(String[] args) {
        String line;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int middleLine = m / 2 + 1;
        int middleCol = n / 2 + 1;
        int i = 0;
        sc.nextLine();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            i++;


            if (i == middleLine) {
                System.out.println(line.charAt(middleCol - 1));
            }


            /* Lisez les données et effectuez votre traitement */
        }
    }
}
