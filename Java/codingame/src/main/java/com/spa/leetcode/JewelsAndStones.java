package com.spa.leetcode;

import java.util.stream.Collectors;

public class JewelsAndStones {

    //https://leetcode.com/problems/jewels-and-stones/submissions/1161899931/
    public int numJewelsInStones(String jewels, String stones) {
        var jewelsSet = jewels.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        return (int) stones.chars().mapToObj(c -> (char)c).filter(jewelsSet::contains).count();
    }
}
