package com.spa;

import java.util.stream.IntStream;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        IntStream.range(-10000, 10000).filter(k -> 2*k+1+ 2* (k*k) + 2*k + 2 *(k*k)+ 2*k +1 == 10000 ).findFirst().ifPresent(n -> System.out.println("Hello f" +n));
        IntStream.range(-10000, 10000).filter(k -> 2*k+ k*k -1 + k*k +1 == 10000 ).findFirst().ifPresent(n -> System.out.println("Hello b" +n));
    }


    
}
