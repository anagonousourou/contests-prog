package com.spa.leetcode.medium;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ApplyDiscountToPrices {

    // https://leetcode.com/problems/apply-discount-to-prices/submissions/1486538650/

    private static final Pattern PRICE_PATTERN = Pattern.compile("\\$\\d+");

    private static final Predicate<String> isPrice = PRICE_PATTERN.asMatchPredicate();


    public String discountPrices(String sentence, int discount) {

        return Arrays.stream(sentence.split("\\s+"))
            .map(token -> {
                if (isPrice.test(token)) {
                    double price = Double.parseDouble(token.substring(1));
                    double discountedPrice = price - (price * discount) / 100.0;
                    return "$%.02f".formatted(discountedPrice);
                } else {
                    return token;
                }
            }).collect(Collectors.joining(" "));
    }
}
