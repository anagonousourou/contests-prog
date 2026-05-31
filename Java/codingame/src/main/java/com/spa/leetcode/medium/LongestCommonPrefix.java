package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    // https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/submissions/2009270985/?envType=daily-question&envId=2026-05-21
    record MyNumber(String value, int array) {

    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        List<MyNumber> numbers = Arrays.stream(arr1)
            .mapToObj(i -> new MyNumber(String.valueOf(i), 1))
            .collect(Collectors.toCollection(ArrayList::new));
        Arrays.stream(arr2).mapToObj(i -> new MyNumber(String.valueOf(i), 2))
            .collect(Collectors.toCollection(() -> numbers));

        numbers.sort(Comparator.comparing(MyNumber::value));
        System.out.println(numbers);
        MyNumber numberFromArray1 = null;
        MyNumber numberFromArray2 = null;
        int maxCount = 0;
        for(var number : numbers.reversed()){
            if(number.array() == 1){
                numberFromArray1 = number;
            }
            if(number.array() == 2){
                numberFromArray2 = number;
            }
            if(numberFromArray2 != null && numberFromArray1 != null){
                int count = 0;
                for (int i = 0; i < Math.min(numberFromArray2.value().length(), numberFromArray1.value().length()); i++) {
                    if(numberFromArray2.value().charAt(i) != numberFromArray1.value().charAt(i)){
                        break;
                    }else{
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }

        }

        return maxCount;
    }
}
