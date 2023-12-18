package com.spa.hackerrank;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'pickingNumbers' function below.
     * https://www.hackerrank.com/challenges/picking-numbers/problem?isFullScreen=true
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        int lower = 0;
        int higher = 1;
        int maxLength = 1;
        int currentLength;
        var sortedList = a.stream().sorted().collect(toList());
        while (higher < sortedList.size()) {
            if (Math.abs(sortedList.get(lower) - sortedList.get(higher)) <= 1) {
                currentLength = (higher - lower) + 1;
                higher++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                lower++;
                if (lower == higher) {
                    higher++;
                }
            }
        }
        return maxLength;
    }
}
