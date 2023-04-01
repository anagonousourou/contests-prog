package com.spa.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaArraylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int i = 0;
        List<List<Integer>> lines = new ArrayList<>();
        while (i < n) {
            i++;
            lines.add(Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.nextLine();
        while (scanner.hasNext()) {
            int line = scanner.nextInt() - 1;
            int position = scanner.nextInt() -1;
            try {
                System.out.println(lines.get(line).get(position));
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("ERROR!");
            }
        }
        scanner.close();

    }
}
