package com.spa.advent2023;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Day4 {


    static final class Card {
        private final int id;
        private final int nbMatchingNumbers;

        private int nbCopies = 1;
        Card(int id, int nbMatchingNumbers) {
            this.id = id;
            this.nbMatchingNumbers = nbMatchingNumbers;
        }

        public int id() {
            return id;
        }

        public int nbMatchingNumbers() {
            return nbMatchingNumbers;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Card) obj;
            return this.id == that.id &&
                this.nbMatchingNumbers == that.nbMatchingNumbers;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nbMatchingNumbers);
        }

        @Override
        public String toString() {
            return "Card[" +
                "id=" + id + ", " +
                "nbMatchingNumbers=" + nbMatchingNumbers + ",nbCopies="+ nbCopies + ']';
        }
    }

    private static int processPart2(List<String> lines){
        var cards = IntStream.range(0, lines.size()).mapToObj(i -> {
            var line = lines.get(i);
            String[] numbers = line.split(":")[1].split("\\|");
            List<Integer> winningNumbers = Arrays.stream(numbers[0].trim().split(" "))
                .filter(Predicate.not(String::isBlank)).map(Integer::valueOf).toList();
            List<Integer> numbersObtained = Arrays.stream(numbers[1].trim().split(" "))
                .filter(Predicate.not(String::isBlank)).map(Integer::valueOf).toList();

            long nbWinningNumbersObtained = numbersObtained.stream()
                .filter(n -> winningNumbers.stream().anyMatch(m -> Objects.equals(m, n)))
                .count();

            return new Card(i+1, (int) nbWinningNumbersObtained);
        }).toList();

        for (int i = 0; i < cards.size(); i++) {
            int limit = Math.min(cards.size(), i + cards.get(i).nbMatchingNumbers);
            for (int j = i + 1; j <= limit; j++) {
                cards.get(j).nbCopies += cards.get(i).nbCopies;
            }
        }

        System.out.println(cards);
        return cards.stream().mapToInt(card -> card.nbCopies).sum();
    }

    private static int processPart(List<String> lines) {
        return lines.stream().mapToInt(line -> {
            String[] numbers = line.split(":")[1].split("\\|");
            List<Integer> winningNumbers = Arrays.stream(numbers[0].trim().split(" "))
                .filter(Predicate.not(String::isBlank)).map(Integer::valueOf).toList();
            List<Integer> numbersObtained = Arrays.stream(numbers[1].trim().split(" "))
                .filter(Predicate.not(String::isBlank)).map(Integer::valueOf).toList();

            long nbWinningNumbersObtained = numbersObtained.stream()
                .filter(n -> winningNumbers.stream().anyMatch(m -> Objects.equals(m, n)))
                .count();

            if (nbWinningNumbersObtained == 0) {
                return 0;
            }
            return (int) Math.pow(2, nbWinningNumbersObtained - 1);

        }).sum();
    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day4.class.getResourceAsStream("/advent2023/day4/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart2(inputLines));
    }
}
