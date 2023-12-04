package com.spa.advent2023;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day3 {

    private static final Pattern SYMBOLS_PATTERN = Pattern.compile("\\D");
    private static final Pattern DIGIT = Pattern.compile("\\d+");

    record Line(int nbLine, String content) {
    }

    record Symbol(int nbLine, int nbCol, String representation) {
    }

    record PartNumber(int nbLine, int nbCol, int numberLength, int value) {
    }

    private static int processPart1(List<String> inputLines) {

        List<Line> lines = IntStream.range(0, inputLines.size()).mapToObj(i -> new Line(i, inputLines.get(i)))
            .toList();

        List<Symbol> allSymbols = getSymbols(lines);

        List<PartNumber> allNumbers = getPartNumbers(lines);

        return allNumbers.stream().filter(partNumber -> allSymbols.stream()
                .anyMatch(symbol -> areAdjacent(symbol, partNumber))).mapToInt(partNumber -> partNumber.value)
            .sum();

    }


    private static int processPart2(List<String> inputLines) {

        List<Line> lines = IntStream.range(0, inputLines.size()).mapToObj(i -> new Line(i, inputLines.get(i)))
            .toList();

        List<Symbol> allSymbols = getSymbols(lines);

        List<PartNumber> allNumbers = getPartNumbers(lines);

        return allSymbols.stream()
            .filter(symbol -> "*".equals(symbol.representation()))
            .filter(symbol -> allNumbers.stream()
                .filter(partNumber -> areAdjacent(symbol, partNumber)).count() == 2)
            .mapToInt(symbol -> allNumbers.stream()
                .filter(partNumber -> areAdjacent(symbol, partNumber)).mapToInt(PartNumber::value).reduce(1, (a, b) -> a * b))
            .sum();

    }


    private static List<PartNumber> getPartNumbers(List<Line> lines) {
        return lines.stream().map(line -> {
            var matcher = DIGIT.matcher(line.content);
            List<PartNumber> numbers = new ArrayList<>();
            while (matcher.find()) {
                numbers.add(new PartNumber(line.nbLine, matcher.start(), matcher.group().length(), Integer.parseInt(matcher.group())));
            }
            return numbers;
        }).flatMap(Collection::stream).toList();
    }

    private static List<Symbol> getSymbols(List<Line> lines) {
        return lines.stream().map(line -> {
            var matcher = SYMBOLS_PATTERN.matcher(line.content);
            List<Symbol> symbols = new ArrayList<>();
            while (matcher.find()) {
                if (!".".equals(matcher.group())) {
                    symbols.add(new Symbol(line.nbLine, matcher.start(), matcher.group()));
                }
            }
            return symbols;
        }).flatMap(Collection::stream).toList();
    }


    static boolean areAdjacent(Symbol symbol, PartNumber partNumber) {
        int lineDiff = Math.abs(symbol.nbLine - partNumber.nbLine);
        if (lineDiff > 1) {
            return false;
        }
        return partNumber.nbCol - 1 <= symbol.nbCol && symbol.nbCol <= partNumber.nbCol + partNumber.numberLength;
    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day3.class.getResourceAsStream("/advent2023/day3/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart2(inputLines));
    }
}
