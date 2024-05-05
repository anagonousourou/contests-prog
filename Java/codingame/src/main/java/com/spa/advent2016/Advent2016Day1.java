package com.spa.advent2016;

import com.spa.advent2023.Day1;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Advent2016Day1 {

    private enum Direction{
        NORTH,
        SOUTH,
        EAST,
        WEST;
    }


    private static int compute(List<String> directions){
        Direction currentDirection = Direction.NORTH;
        Map<Direction, Integer> moves = new EnumMap<>(Direction.class);
        for(String direction : directions){
            char move = direction.charAt(0);
            if(move == 'R' && currentDirection == Direction.EAST){
                currentDirection = Direction.SOUTH;
            }
            else if(move == 'R' && currentDirection == Direction.WEST){
                currentDirection = Direction.NORTH;
            }
            else if(move == 'R' && currentDirection == Direction.NORTH){
                currentDirection = Direction.EAST;
            }
            else if(move == 'R' && currentDirection == Direction.SOUTH){
                currentDirection = Direction.WEST;
            }
            else if(move == 'L' && currentDirection == Direction.EAST){
                currentDirection = Direction.NORTH;
            }
            else if(move == 'L' && currentDirection == Direction.WEST){
                currentDirection = Direction.SOUTH;
            }
            else if(move == 'L' && currentDirection == Direction.NORTH){
                currentDirection = Direction.WEST;
            }
            else if(move == 'L' && currentDirection == Direction.SOUTH){
                currentDirection = Direction.EAST;
            }

            moves.put(currentDirection, moves.getOrDefault(currentDirection, 0) + Integer.parseInt(direction.substring(1)));
        }

        return Math.abs(moves.getOrDefault(Direction.EAST, 0) - moves.getOrDefault(Direction.WEST, 0)) + Math.abs(moves.getOrDefault(Direction.SOUTH, 0) - moves.getOrDefault(Direction.NORTH, 0)) ;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(compute(List.of("R5", "L5", "R5", "R3")));
        System.out.println(compute(List.of("R2", "R2", "R2")));
        System.out.println(compute(List.of("R2", "L3")));

        var inputLines = Arrays.stream(new String(Advent2016Day1.class.getResourceAsStream("/advent2016/day1.txt").readAllBytes()).split(","))
            .map(String::trim).filter(Predicate.not(String::isBlank)).toList();
        System.out.println(compute(inputLines));
    }
}
