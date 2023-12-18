package com.spa.codewars;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FibonacciStreaming {

    record FibStep(int a, int b) {
    }

    public static IntStream generateFibonacciSequence() {
        return Stream.iterate(new FibStep(1, 1), fibStep -> new FibStep(fibStep.b(), fibStep.b() + fibStep.a()))
            .mapToInt(FibStep::a);
    }
}
