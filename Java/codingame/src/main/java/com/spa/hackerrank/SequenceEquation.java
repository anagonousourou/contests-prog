package com.spa.hackerrank;

import java.util.List;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class SequenceEquation {

    /*
     * Complete the 'permutationEquation' function below.
     *  https://www.hackerrank.com/challenges/permutation-equation/problem?isFullScreen=true
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
        Map<Integer, Integer> valuesMapping = new HashMap<>();
        for (int i = 0; i < p.size(); i++) {
            valuesMapping.put(p.get(i), i + 1);
        }

        return IntStream.rangeClosed(1, p.size()).map(valuesMapping::get).map(valuesMapping::get)
                        .boxed().collect(toList());

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = permutationEquation(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
