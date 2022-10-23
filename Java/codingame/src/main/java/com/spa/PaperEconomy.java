package com.spa;

import java.util.Scanner;

public class PaperEconomy {
    
    public static void main(String[] args) {
        String  line;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			line = sc.nextLine();
            minimumPages(convertToInts(line.split(" "))) ;
			/* Lisez les données et effectuez votre traitement */
		}

    }

    private static int[] convertToInts(String[] args){
        int[] results = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            results[i] = Integer.parseInt(args[i]);
        }
        return results;
    }

    

    private static int minimumPages(int[] imagesHeight){
        int nbPages = 1;
        int remainingHeight = 10;
        for (int index = 0; index < imagesHeight.length; index++) {
            if(remainingHeight < imagesHeight[index]){
                nbPages++;
                remainingHeight = 10 - imagesHeight[index];
            }
            else{
                remainingHeight = remainingHeight - imagesHeight[index]; 
            }
        }

        return nbPages;
    }
}
