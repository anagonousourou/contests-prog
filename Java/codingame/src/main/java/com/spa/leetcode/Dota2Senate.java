package com.spa.leetcode;

import com.spa.commonfns.StringHelpers;

//https://leetcode.com/problems/dota2-senate/
public class Dota2Senate {

    public static String predictPartyVictory(String senate) {
        var senateConstitution = StringHelpers.frequencies(senate);


        while (true) {
            long nbAlive = senateConstitution.getOrDefault('R', 0L) + senateConstitution.getOrDefault('D', 0L);
            for (int i = 0; i < senate.length(); i++) {

                if (senateConstitution.getOrDefault('R', 0L) <= 0) {
                    return "Dire";
                }

                if (senateConstitution.getOrDefault('D', 0L) <= 0) {
                    return "Radiant";
                }

                if (senate.charAt(i) == 'R' && senateConstitution.get('R') > 0) {
                    senateConstitution.put('D', senateConstitution.getOrDefault('D', 1L) - 1);
                    nbAlive -= 2;
                } else if (senate.charAt(i) == 'D' && senateConstitution.get('D') > 0) {
                    senateConstitution.put('R', senateConstitution.getOrDefault('R', 1L) - 1);
                    nbAlive -= 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DDRRR"));
    }
}
