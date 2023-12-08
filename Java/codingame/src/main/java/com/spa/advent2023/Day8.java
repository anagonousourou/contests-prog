package com.spa.advent2023;

import com.spa.commonfns.NumberHelpers;
import com.spa.commonfns.StringHelpers;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day8 {

    private static final Pattern NODE_NAME_PATTERN = Pattern.compile("\\p{Alnum}+");

    private record Node(String name, String left, String right) {
    }

    static List<Node> getNodes(List<String> inputLines) {
        return inputLines.stream().map(line -> {
            var names = StringHelpers.reSeq(NODE_NAME_PATTERN, line).stream().toList();
            return new Node(names.get(0), names.get(1), names.get(2));
        }).toList();
    }


    private static int processPart1(List<String> inputLines) {
        inputLines = inputLines.stream().filter(Predicate.not(String::isBlank)).toList();
        var sequences = inputLines.get(0);
        var nodes = getNodes(inputLines.subList(1, inputLines.size()));
        var nodesMap = nodes.stream().collect(Collectors.toMap(node -> node.name, Function.identity()));

        var currentNode = nodesMap.get("AAA");
        int i = 0;
        int count = 0;

        while (true) {
            if (sequences.charAt(i) == 'L') {
                currentNode = nodesMap.get(currentNode.left);
            } else {
                currentNode = nodesMap.get(currentNode.right);
            }
            i = (i + 1) % sequences.length();
            count++;
            if ("ZZZ".equals(currentNode.name)) {
                return count;
            }
        }
    }

    private static int process(java.util.Map<String, Day8.Node> nodesMap, String sequences, String startingNode) {
        var currentNode = nodesMap.get(startingNode);
        int i = 0;
        int count = 0;

        while (!currentNode.name.endsWith("Z")) {
            if (sequences.charAt(i) == 'L') {
                currentNode = nodesMap.get(currentNode.left);
            } else {
                currentNode = nodesMap.get(currentNode.right);
            }
            i = (i + 1) % sequences.length();
            count++;
        }
        return count;
    }

    private static long processPart2(List<String> inputLines) {
        inputLines = inputLines.stream().filter(Predicate.not(String::isBlank)).toList();
        var sequences = inputLines.get(0);
        var nodes = getNodes(inputLines.subList(1, inputLines.size()));
        var currentNodes = nodes.stream().filter(node -> node.name.endsWith("A")).toList();

        var nodesMap = nodes.stream().collect(Collectors.toMap(node -> node.name, Function.identity()));

        return currentNodes.stream().mapToLong(currentNode -> process(nodesMap, sequences, currentNode.name)).reduce(NumberHelpers::lcm).orElse(0);
    }

    public static void main(String[] args) throws IOException {
        var inputLines = new String(Day8.class.getResourceAsStream("/advent2023/day8/actual-input").readAllBytes()).lines()
            .toList();
        System.out.println(processPart2(inputLines));
    }
}
