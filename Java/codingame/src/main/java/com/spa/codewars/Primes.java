package com.spa.codewars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Primes {

    public static IntStream stream() {

        Map<Integer, Set<Integer>> compositeIterators = new HashMap<>();
        compositeIterators.put(4, new HashSet<>(Set.of(2)));
        IntPredicate isPrime = i -> {
            if(compositeIterators.containsKey(i)){
                Set<Integer> primeNumberMultiplesOfI = compositeIterators.get(i);
                compositeIterators.remove(i);
                primeNumberMultiplesOfI.forEach(p -> {
                    compositeIterators.compute((p + i),(key, value) -> {
                        if(value == null){
                            return new HashSet<>(Set.of(p));
                        }
                        else{
                            value.add(p);
                            return value;
                        }
                    });
                });
                return false;
            }
            else{
                compositeIterators.compute(i+i, (key, value) ->{
                    if(value == null){
                        return new HashSet<>(Set.of(i));
                    }
                    else{
                        value.add(i);
                        return value;
                    }
                });
                return true;
            }

        };
        return IntStream.iterate(2, i -> i + 1).filter(isPrime);
    }
}
