package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RelativeRanks {

    //https://leetcode.com/problems/relative-ranks/submissions/1252598290/
    public String[] findRelativeRanks(int[] score) {
        List<Athlete> athleteList = new ArrayList<>(score.length);
        for (int i = 0; i < score.length; i++) {
            athleteList.add(new Athlete(score[i], i));
        }

        athleteList.sort(Comparator.comparing(Athlete::score).reversed());
        for (int i = 0; i < athleteList.size(); i++) {
            if (i == 0) {
                athleteList.get(i).setRank("Gold Medal");
            } else if (i == 1) {
                athleteList.get(i).setRank("Silver Medal");
            } else if (i == 2) {
                athleteList.get(i).setRank("Bronze Medal");
            } else {
                athleteList.get(i).setRank(Integer.toString(i + 1));
            }
        }

        athleteList.sort(Comparator.comparing(Athlete::position));
        return athleteList.stream().map(Athlete::getRank).toArray(String[]::new);
    }

    private static final class Athlete {
        private final int score;
        private final int position;

        private String rank;

        private Athlete(int score, int position) {
            this.score = score;
            this.position = position;
        }

        public int score() {
            return score;
        }

        public int position() {
            return position;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }
    }
}
