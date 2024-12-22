package com.spa.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DivideString {

    // https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/submissions/1476092566/
    public String[] divideString(String s, int k, char fill) {
        List<String> groups = new ArrayList<>();
        if (s.length() % k != 0) {
            s = s + ("" + fill).repeat(k - (s.length() % k));
        }
        for (int i = 0; i < s.length(); i += k) {
            groups.add(s.substring(i, i + k));
        }
        return groups.toArray(new String[0]);
    }

}
