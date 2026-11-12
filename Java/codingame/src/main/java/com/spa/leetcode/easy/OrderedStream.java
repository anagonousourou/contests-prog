package com.spa.leetcode.easy;

import java.util.*;
import java.util.stream.IntStream;

// https://leetcode.com/problems/design-an-ordered-stream/submissions/2143833967/
public class OrderedStream {

    enum PairState {
        RETURNED,
        PRESENT,
        MISSING // or null
    }

    private final Map<Integer, String> entries;
    private final PairState[] pairStates;

    public OrderedStream(int n) {
        entries = new HashMap<>(n);
        pairStates = new PairState[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        entries.put(idKey, value);
        pairStates[idKey] = PairState.PRESENT;

        int i = 1;
        while (i < pairStates.length && (pairStates[i] == PairState.RETURNED || pairStates[i] == PairState.PRESENT)) {
            i++;
        }
        List<String> chunks = IntStream.range(1, i).filter(j -> pairStates[j] == PairState.PRESENT)
            .mapToObj(entries::get)
            .toList();

        for (int j = 1; j < i; j++) {
            pairStates[j] = PairState.RETURNED;
        }
        return chunks;
    }
}
