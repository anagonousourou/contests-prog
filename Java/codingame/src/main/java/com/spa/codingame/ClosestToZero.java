package com.spa.codingame;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestToZero {

     public static int closest(int[] ints){
         return Arrays.stream(ints).boxed()
             .min(Comparator.<Integer, Integer>comparing(Math::abs)
                 .thenComparing(i -> -i)).orElse(0);
     }
}
