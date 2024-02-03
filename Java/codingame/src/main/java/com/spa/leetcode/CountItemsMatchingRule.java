package com.spa.leetcode;

import java.util.List;

public class CountItemsMatchingRule {

    //https://leetcode.com/problems/count-items-matching-a-rule/
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        return (int) items.stream().filter(item ->
            switch (ruleKey) {
                case "type" -> ruleValue.equals(item.get(0));
                case "color" -> ruleValue.equals(item.get(1));
                case "name" -> ruleValue.equals(item.get(2));
                default -> false;
            }
        ).count();
    }
}
