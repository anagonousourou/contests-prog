package com.spa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
        int highestDifficulty = Arrays.stream(tasks).max().getAsInt();

        Map<Integer, Integer> groupedTasks = new HashMap<>();

        for (int task : tasks) {
            groupedTasks.compute(task, (key, value) -> value == null ? 1 : value + 1);
        }
        if (groupedTasks.values().stream().map(this::minimumRounds).anyMatch(Predicate.not(OkErr::doable))) {
            return -1;
        }
        return groupedTasks.values().stream().map(this::minimumRounds).mapToInt(OkErr::minRounds).sum();
    }

    public record OkErr(boolean doable, int minRounds) {

    }

    public OkErr minimumRounds(int nbTaskOfSameDifficulty) {
        if (nbTaskOfSameDifficulty == 0) {
            return new OkErr(true, 0);
        }
        if (nbTaskOfSameDifficulty == 1) {
            return new OkErr(false, -1);
        }
        if (nbTaskOfSameDifficulty % 3 == 0) {
            return new OkErr(true, nbTaskOfSameDifficulty / 3);
        }
        if (nbTaskOfSameDifficulty % 3 == 1) {
            return new OkErr(true, (nbTaskOfSameDifficulty / 3) + 2);
        }

        if (nbTaskOfSameDifficulty % 3 == 2) {

            return new OkErr(true, (nbTaskOfSameDifficulty / 3) + 1);
        }
        return new OkErr(true, 0);
    }


}
