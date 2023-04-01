package com.spa.codewars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Primes {

    public static IntStream stream() {

        Map<Long, Set<Long>> compositeIterators = new HashMap<>();
        compositeIterators.put(4L, new HashSet<>(Set.of(2L)));
        IntPredicate isPrime = i -> {
            if(compositeIterators.containsKey((long) i)){
                Set<Long> primeNumberMultiplesOfI = compositeIterators.get((long) i);
                compositeIterators.remove((long)i);
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
                compositeIterators.compute((((long)i) * i), (key, value) ->{
                    if(value == null){
                        return new HashSet<>(Set.of((long)i));
                    }
                    else{
                        value.add((long)i);
                        return value;
                    }
                });
                return true;
            }

        };
        return IntStream.iterate(2, i -> i + 1).filter(isPrime);
    }
}
