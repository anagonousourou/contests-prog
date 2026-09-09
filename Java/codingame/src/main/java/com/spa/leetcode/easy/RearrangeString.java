package com.spa.leetcode.easy;

import java.util.stream.Collectors;

public class RearrangeString {

    // https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/submissions/2125070399/
    public String rearrangeString(String s, char x, char y) {
        return s.chars().mapToObj(c -> (char) c)
            .sorted((a, b) -> {
                if(a == y){
                    return -1;
                }
                else if(b == y){
                    return 1;
                }
                else{
                   return Character.compare(a, b);
                }
            }).map(String::valueOf).collect(Collectors.joining());
    }
}
