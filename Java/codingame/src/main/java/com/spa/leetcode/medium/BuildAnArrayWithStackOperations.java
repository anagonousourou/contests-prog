package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    // https://leetcode.com/problems/build-an-array-with-stack-operations/submissions/1835359156/

    public List<String> buildArray(int[] target, int n) {
        BitSet set = new BitSet(n + 1);
        for (int elt : target) {
            set.set(elt);
        }

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= target[target.length - 1]; i++) {
            if (set.get(i)) {
                result.add("Push");
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}
