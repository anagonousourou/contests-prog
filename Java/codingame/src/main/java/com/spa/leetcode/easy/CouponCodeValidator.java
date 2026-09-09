package com.spa.leetcode.easy;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class CouponCodeValidator {

    // https://leetcode.com/problems/coupon-code-validator/submissions/2125063788/
    record Coupon(String code, String businessLine, boolean isActive){

    }


    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        return IntStream.range(0, code.length).mapToObj(i -> new Coupon(code[i], businessLine[i], isActive[i]))
            .filter(coupon -> Set.of("electronics", "grocery", "pharmacy", "restaurant")
                .contains(coupon.businessLine()) && coupon.isActive() && !coupon.code().isBlank() && coupon.code().chars().allMatch(x -> Character.isAlphabetic(x) || Character.isDigit(x) || x == '_'))
            .sorted(Comparator.comparing(Coupon::businessLine).thenComparing(Coupon::code))
            .map(Coupon::code)
            .toList();
    }
}
