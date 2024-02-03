package com.spa.commonfns;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringHelpers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while (scanner.hasNextLine()) {
            short op = scanner.nextShort();
            int num = scanner.nextInt();
            switch (op) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }


    }

    //https://leetcode.com/problems/check-if-the-sentence-is-pangram/
    //WARNING: has to be adapted depending on the input space
    public boolean isPangram(String sentence) {
        return sentence.chars().distinct().count() == 26;
    }

    public static List<String> slices(String input, int sliceLength) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i + sliceLength <= input.length(); i++) {
            result.add(input.substring(i, i + sliceLength));
        }
        return result;
    }

    public static boolean areAnagrams(List<String> candidates) {
        return candidates.stream().map(StringHelpers::frequencies).collect(Collectors.toSet()).size() == 1;
    }

    public static <A> Map<A, Long> frequencies(List<A> elements) {
        return elements.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static <A> Map<A, Integer> frequenciesInteger(List<A> elements) {
        return elements.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    /**
     * Compute the frequency of the characters of the String in a case insensitive way
     *
     * @param elements a string
     * @return frequency of the character of elements
     */
    public static Map<Character, Long> frequencies(String elements) {
        return elements.toLowerCase().chars().mapToObj(a -> (char) a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * reSeq(Pattern.compile("\\p{Alpha}+"), "Hello, World7 '17") => [Hello, World]
     * reSeq(Pattern.compile("\\d+"), "Hello, World 17")          => [17]
     *
     * @param re    regex
     * @param input the input
     * @return return the tokens matching the regex re
     */
    public static List<String> reSeq(Pattern re, String input) {
        List<String> tokens = new ArrayList<>();
        Matcher m = re.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    public static char last(String input) {
        return input.charAt(input.length() - 1);
    }

    public static char first(String input) {
        return input.charAt(0);
    }

    public static <A> A first(List<A> input) {
        return input.get(0);
    }

    public static <A> List<A> rest(List<A> input) {
        if (input.size() <= 1) {
            return List.of();
        }
        return input.subList(1, input.size());
    }

    public static <A> A last(List<A> input) {
        return input.get(input.size() - 1);
    }


    public static boolean isPalindrome(String input) {
        if (input.length() == 1 || input.length() == 0) {
            return true;
        } else if (last(input) == first(input)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        } else {
            return false;
        }
    }

    public static List<String> substrings(String input, int k) {
        List<String> subs = new ArrayList<>(input.length() - k + 1);
        for (int i = 0; i < input.length() - k + 1; i++) {
            subs.add(input.substring(i, i + k));
        }
        return subs;
    }

    public static String randomAlphabetic(int count, Random random) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append((char) random.nextInt(97, 122));
        }
        return stringBuilder.toString();
    }

    /**
     * @param originalMap a map where the values are collections
     * @param <KeyType>   type parameter of the key in the result
     * @param <ValueType> type parameter of the value in the result
     * @return a map where the elements of the collections are now the keys
     */
    static <KeyType, ValueType> Map<KeyType, ValueType> transform(Map<ValueType, Collection<KeyType>> originalMap) {
        Map<KeyType, ValueType> newMap = new HashMap<>();
        originalMap.forEach(((valueType, keyTypes) ->
            keyTypes.forEach(keyType ->
                newMap.put(keyType, valueType)
            )
        ));
        return newMap;
    }

    private static final Set<String> OPENING_BRACKETS = Set.of("(", "{", "[");
    private static final Set<String> CLOSING_BRACKETS = Set.of(")", "}", "]");
    private static final Map<String, String> MATCHING_BRACKETS = Map.of("(", ")", "{", "}", "[", "]");

    public static boolean isPairedRecursive(String brackets, Stack<String> bracketsStacks) {
        String first = brackets.isEmpty() ? "" : brackets.substring(0, 1);
        String rest = brackets.isEmpty() ? "" : brackets.substring(1);
        if (brackets.isEmpty()) {
            return bracketsStacks.isEmpty();
        } else if (OPENING_BRACKETS.contains(first)) {
            bracketsStacks.push(MATCHING_BRACKETS.get(first));
            return isPairedRecursive(rest, bracketsStacks);
        } else if (CLOSING_BRACKETS.contains(first) && !bracketsStacks.isEmpty() && first.equals(bracketsStacks.peek())) {
            bracketsStacks.pop();
            return isPairedRecursive(rest, bracketsStacks);
        } else if (CLOSING_BRACKETS.contains(first) && (bracketsStacks.isEmpty() || !first.equals(bracketsStacks.peek()))) {
            return false;
        } else {
            return isPairedRecursive(rest, bracketsStacks);
        }
    }

    public static String md5(String input) {
        try {
            byte[] bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            return String.format("%032x", new BigInteger(1, thedigest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha256(String input) {
        try {
            byte[] bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] thedigest = md.digest(bytesOfMessage);
            return String.format("%064x", new BigInteger(1, thedigest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Object> flatten(Object object, List<Object> result) {
        if (object == null) {
            return result;
        }
        if (object instanceof List) {
            List<Object> objects = (List<Object>) object;
            if (objects.isEmpty()) {
                return result;
            } else {
                flatten(first(objects), result);
                return flatten(rest(objects), result);
            }
        } else {
            result.add(object);
            return result;
        }

    }

}
