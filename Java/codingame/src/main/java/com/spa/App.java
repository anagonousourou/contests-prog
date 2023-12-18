package com.spa;

import com.spa.leetcode.SolutionLeetCode;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        var algos = new SolutionLeetCode();
        System.out.println(algos.firstBadVersion(2126753390));
    }

}
