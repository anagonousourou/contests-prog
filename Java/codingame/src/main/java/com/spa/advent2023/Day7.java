package com.spa.advent2023;

import com.spa.commonfns.StringHelpers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day7 {

    private enum HandType{
        UNKNOWN,
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE,
        FULL_HOUSE,
        FOUR,
        FIVE,
    }

    private enum CardValue{UNKNOWN, L2, L3, L4, L5, L6, L7, L8, L9, T, J, Q, K, A}
    private record GameHand(List<CardValue> cards, int bid, Map<CardValue, Long> occurrences) implements Comparable<GameHand> {

        static HandType getHandType(Map<CardValue, Long> occurrences){
            if(occurrences.size() == 5){
                return HandType.HIGH_CARD;
            }
            if(occurrences.size() == 1){
                return HandType.FIVE;
            }
            if(occurrences.size() == 2 && occurrences.containsValue(4L)){
                return HandType.FOUR;
            }
            if(occurrences.size() == 2 && occurrences.containsValue(3L)){
                return HandType.FULL_HOUSE;
            }

            if(occurrences.size() == 3 && occurrences.containsValue(3L)){
                return HandType.THREE;
            }
            if(occurrences.size() == 3 &&  occurrences.containsValue(2L)){
                return HandType.TWO_PAIR;
            }

            if(occurrences.size() == 4){
                return HandType.ONE_PAIR;
            }
            return HandType.UNKNOWN;
        }


        @Override
        public int compareTo(GameHand gameHand) {
            var xHandType = getHandType(gameHand.occurrences);
            var yHandType = getHandType(this.occurrences);
            if(xHandType == yHandType){
                for (int i = 0; i < 5; i++) {
                    if(gameHand.cards.get(i) != this.cards.get(i)){
                        return this.cards.get(i).compareTo(gameHand.cards.get(i));
                    }
                }
            }
            return yHandType.compareTo(xHandType);
        }
    }

    private static GameHand convert(String line){
       var parts = line.split(" ");
       String cards = parts[0];
       List<CardValue> cardValues = Arrays.stream(cards.split("")).map(card -> switch (card){
           case "A" -> CardValue.A;
           case "K" -> CardValue.K;
           case "Q" -> CardValue.Q;
           case "J" -> CardValue.J;
           case "T" -> CardValue.T;
           case "9" -> CardValue.L9;
           case "8" -> CardValue.L8;
           case "7" -> CardValue.L7;
           case "6" -> CardValue.L6;
           case "5" -> CardValue.L5;
           case "4" -> CardValue.L4;
           case "3" -> CardValue.L3;
           case "2" -> CardValue.L2;
           default -> CardValue.UNKNOWN;
       }).toList();
       int bid = Integer.parseInt(parts[1]);
       return new GameHand(cardValues, bid, StringHelpers.frequencies(cardValues));
    }

    private static int processPart1(List<String> inputLines) {
        var hands = inputLines.stream().map(Day7::convert).sorted().toList();
        return IntStream.range(0, hands.size()).map(i -> hands.get(i).bid * (i + 1)).sum();
    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day6.class.getResourceAsStream("/advent2023/day7/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart1(inputLines));
    }
}
