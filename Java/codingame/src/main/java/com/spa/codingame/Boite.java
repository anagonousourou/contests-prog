package com.spa.codingame;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Boite {
    public static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
        int total = Arrays.stream(boxes).sum();
        System.err.println(clawPos);
        int nbBoxPerPlace = total / boxes.length;
        if (!boxInClaw) {
            int toReduceIndex = -1;

            for (int i = clawPos; i < boxes.length; i++) {
                if (boxes[i] > nbBoxPerPlace) {
                    toReduceIndex = i;
                    break;
                }
            }
            if (toReduceIndex == -1) {
                for (int i = 0; i < boxes.length; i++) {
                    if (boxes[i] > nbBoxPerPlace) {
                        toReduceIndex = i;
                        break;
                    }
                }
            }

            if (clawPos == toReduceIndex) {
                return "PICK";
            } else if (clawPos < toReduceIndex) {
                return "RIGHT";
            } else {
                return "LEFT";
            }


        } else {
            int toIncreaseIndex = 0;
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] < nbBoxPerPlace) {
                    toIncreaseIndex = i;
                    break;
                }
            }

            if (clawPos == toIncreaseIndex) {
                return "PLACE";
            } else if (clawPos < toIncreaseIndex) {
                return "RIGHT";
            } else {
                return "LEFT";
            }
        }
    }

    /* Ignore and do not change the code below */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int clawPos = in.nextInt();
            boolean boxInClaw = in.nextInt() != 0;
            int stacks = in.nextInt();
            int[] boxes = new int[stacks];
            for (int i = 0; i < stacks; i++) {
                boxes[i] = in.nextInt();
            }
            PrintStream outStream = System.out;
            System.setOut(System.err);
            String action = solve(clawPos, boxes, boxInClaw);
            System.setOut(outStream);
            System.out.println(action);
        }
    }
    /* Ignore and do not change the code above */
}
