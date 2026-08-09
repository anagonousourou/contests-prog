package com.spa.leetcode.easy;

public class HaveConflict {

    //https://leetcode.com/problems/determine-if-two-events-have-conflict/submissions/2100082636/
    public boolean haveConflict(String[] event1, String[] event2) {
        return between(event2[0], event1[0], event1[1]) || between(event1[0], event2[0], event2[1]);
    }

    boolean between(String candidate, String start, String end){
        return candidate.compareTo(start) >= 0 && candidate.compareTo(end) <= 0;
    }
}
