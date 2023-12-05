package com.spa.advent2023;

import com.spa.commonfns.StringHelpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class Day5 {

    record Range(long sourceStart, long sourceEnd, long destStart, long destEnd) {
        boolean containsSource(long s) {
            return (sourceStart <= s && s <= sourceEnd);
        }

        boolean containsDest(long s) {
            return (destStart <= s && s <= destEnd);
        }

        long f(long x) {
            return destStart + (x - sourceStart);
        }

        long reciproqF(long y) {
            return sourceStart + (y - destStart);
        }

    }

    record Mapping(List<Range> ranges) {
        long f(long source) {
            return ranges.stream().filter(range -> range.containsSource(source)).findFirst().map(range -> range.f(source))
                .orElse(source);
        }

        long reciproqF(long y) {
            return ranges.stream().filter(range -> range.containsDest(y)).findFirst().map(range -> range.reciproqF(y))
                .orElse(y);
        }
    }

    private static long process(List<String> inputLines) {
        inputLines = inputLines.stream().filter(Predicate.not(String::isBlank)).toList();
        List<Long> seeds = getSeeds(inputLines);
        List<Mapping> mappings = getMappings(inputLines);

        System.out.printf("%d \n %s\n", mappings.size(), mappings);

        return seeds.stream().map(seed -> mappings.stream().reduce(seed, (a, mapping) -> mapping.f(a), (a, b) -> a))
            .min(Long::compareTo).orElseThrow();
    }


    private static long processPart2(List<String> inputLines) {
        inputLines = inputLines.stream().filter(Predicate.not(String::isBlank)).toList();
        List<Long> seeds = getSeeds(inputLines);
        List<Mapping> mappings = getMappings(inputLines);

        List<Mapping> reverseMappings = new ArrayList<>(mappings);
        Collections.reverse(reverseMappings);

        return LongStream.rangeClosed(0, Long.MAX_VALUE).filter(location -> {
                long seed = reverseMappings.stream().reduce(location, (a, mapping) -> mapping.reciproqF(a), (a, b) -> a);
                for (int i = 0; i < seeds.size(); i += 2) {
                    if (seed >= seeds.get(i) && seed < seeds.get(i) + seeds.get(i + 1)) {
                        return true;
                    }
                }
                return false;
            }
        ).findFirst().orElseThrow();
    }

    private static List<Mapping> getMappings(List<String> inputLines) {
        List<Mapping> mappings = new ArrayList<>();
        List<Range> ranges = new ArrayList<>();
        for (int i = 2; i < inputLines.size(); i++) {
            if (inputLines.get(i).contains("map")) {
                mappings.add(new Mapping(new ArrayList<>(ranges)));
                ranges.clear();
            } else {
                List<Long> rangeData = StringHelpers.reSeq(Pattern.compile("\\d+"),
                    inputLines.get(i)).stream().map(Long::valueOf).toList();

                ranges.add(new Range(rangeData.get(1), rangeData.get(1) + rangeData.get(2),
                    rangeData.get(0), rangeData.get(0) + rangeData.get(2)));
            }
        }
        mappings.add(new Mapping(new ArrayList<>(ranges)));
        return mappings;
    }

    private static List<Long> getSeeds(List<String> inputLines) {
        return StringHelpers.reSeq(Pattern.compile("\\d+"), inputLines.get(0)).stream().map(Long::valueOf).toList();
    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day5.class.getResourceAsStream("/advent2023/day5/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart2(inputLines));
    }
}
