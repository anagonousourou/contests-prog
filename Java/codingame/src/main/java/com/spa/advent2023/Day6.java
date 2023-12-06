package com.spa.advent2023;

import com.spa.commonfns.StringHelpers;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Day6 {

    record Race(int time, int distance){}
    private static int processPart1(List<String> inputLines){
        var times = StringHelpers.reSeq(Pattern.compile("\\d+"), inputLines.get(0)).stream().map(Integer::valueOf).toList();
        var distances = StringHelpers.reSeq(Pattern.compile("\\d+"), inputLines.get(1)).stream().map(Integer::valueOf).toList();

        return IntStream.range(0, times.size()).mapToObj(i -> new Race(times.get(i), distances.get(i)))
            .mapToInt(race -> Math.toIntExact(
                IntStream.range(1, race.time).filter(pushTime -> -(pushTime * pushTime) + race.time * pushTime - race.distance > 0)
                .count())).reduce(1, (a, b) -> a* b);
    }

    private static long processPart2(List<String> inputLines){
         inputLines = inputLines.stream().map(s -> s.replaceAll("\\s+","")).toList();
        var time = StringHelpers.reSeq(Pattern.compile("\\d+"), inputLines.get(0)).stream().map(BigInteger::new).toList().get(0);
        var distance = StringHelpers.reSeq(Pattern.compile("\\d+"), inputLines.get(1)).stream().map(BigInteger::new).toList().get(0);

        var discriminant =  (time.multiply(time)).add(distance.multiply(BigInteger.valueOf(-4)));

        var x1 = ( time.negate().add(discriminant.sqrt())).divide(BigInteger.valueOf(-2));
        var x2 = ( time.negate().subtract(discriminant.sqrt())).divide(BigInteger.valueOf(-2));

        System.out.printf("distance = %s, time = %s\n", distance, time);
        System.out.printf("x1 = %s ,\n x2 = %s \n", x1, x2);
        return LongStream.range(x1.longValue(), time.longValue()).filter(pushTime -> pushTime * (time.longValue() - pushTime) > distance.longValue())
                .count();
    }


    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day6.class.getResourceAsStream("/advent2023/day6/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart2(inputLines));
    }
}
