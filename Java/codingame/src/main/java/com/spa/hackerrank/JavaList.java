package com.spa.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {

    /**
     * this has some bugs
     * @param args
     */
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            List<Integer> myList = new LinkedList<>(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
            int nbQueries = Integer.parseInt(scanner.nextLine());

            while(scanner.hasNextLine()) {
                String operation = scanner.nextLine();
                if("Insert".equals(operation)){
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if(scanner.hasNextLine()){
                        scanner.nextLine();
                    }
                    myList.add(x, y);
                }else{
                    String tmpLine = scanner.nextLine();
                    int x = Integer.parseInt(tmpLine);
                    myList.remove(x);
                }
            }
            System.out.println(myList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }catch (RuntimeException e){
            System.out.println(e);
        }

    }
}
