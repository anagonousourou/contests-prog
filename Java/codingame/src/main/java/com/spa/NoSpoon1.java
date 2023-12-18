package com.spa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
public class NoSpoon1 {

    /**
     * Cell
     * <p>
     * public record Cell(int i, int j) {
     * }
     */

    static class Cell {
        int i;
        int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + i;
            result = prime * result + j;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Cell other = (Cell) obj;
            if (i != other.i)
                return false;
            if (j != other.j)
                return false;
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        String[][] grid = new String[height][];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // on représente la grille
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            grid[i] = line.split("");
        }

        //

        Map<Cell, Cell> rightDirectNeightbors = new HashMap<>();
        Map<Cell, Cell> bottomDirectNeightbors = new HashMap<>();
        System.err.println(Arrays.toString(grid[0]));
        for (int i = 0; i < height; i++) {
            Cell currentNode = null;
            for (int j = 0; j < width; j++) {
                if ("0".equals(grid[i][j])) {
                    if (currentNode == null) {
                        currentNode = new Cell(i, j);
                    } else {
                        rightDirectNeightbors.put(currentNode, new Cell(i, j));
                        currentNode = new Cell(i, j);
                    }
                }
            }
        }

        for (int j = 0; j < width; j++) {
            Cell currentNode = null;
            for (int i = 0; i < height; i++) {
                if ("0".equals(grid[i][j])) {
                    if (currentNode == null) {
                        currentNode = new Cell(i, j);
                    } else {
                        bottomDirectNeightbors.put(currentNode, new Cell(i, j));
                        currentNode = new Cell(i, j);
                    }
                }
            }
        }
        Cell defaultNeighbors = new Cell(-1, -1);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ("0".equals(grid[i][j])) {

                    System.out.print(j + " " + i + " ");
                    Cell rightNeighbor = rightDirectNeightbors.getOrDefault(new Cell(i, j), defaultNeighbors);
                    System.out.print(rightNeighbor.j + " " + rightNeighbor.i + " ");
                    Cell bottomNeighbor = bottomDirectNeightbors.getOrDefault(new Cell(i, j), defaultNeighbors);
                    System.out.print(bottomNeighbor.j + " " + bottomNeighbor.i + " ");

                    System.out.println();
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
}
