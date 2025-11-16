package com.spa.leetcode.medium;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PeopleAwareOfSecret {


    //https://leetcode.com/problems/number-of-people-aware-of-a-secret/submissions/1765060988/?envType=daily-question&envId=2025-09-09
    public int peopleAwareOfSecret(int n, int delay, int forget){
        Map<Integer, BigInteger> dayToForget = new HashMap<>();
        Map<Integer, BigInteger> nbPeopleDelayedPerDay = new HashMap<>();
        BigInteger nbPeopleWithSecret = new BigInteger("1");
        dayToForget.put(1 + forget, BigInteger.ONE);

        for (int i = 1; i < 1 + delay; i++) {
            nbPeopleDelayedPerDay.put(i , BigInteger.ONE);
        }

        for (int i = 2; i <= n; i++) {
            nbPeopleWithSecret = nbPeopleWithSecret.subtract(dayToForget.getOrDefault(i, BigInteger.ZERO));
            BigInteger newPeopleWithSecret = nbPeopleWithSecret.subtract(nbPeopleDelayedPerDay.getOrDefault(i, BigInteger.ZERO));
            for (int j = i + 1; j < i + delay; j++) {
                nbPeopleDelayedPerDay.put(j , nbPeopleDelayedPerDay.getOrDefault(j, BigInteger.ZERO).add(newPeopleWithSecret));
            }
            dayToForget.put(i + forget, newPeopleWithSecret);
            nbPeopleWithSecret = nbPeopleWithSecret.add(newPeopleWithSecret);

            /*System.out.println("Day " + i);
            System.out.println("nbPeopleWithSecret " + nbPeopleWithSecret);
            System.out.println("dayToForget " + dayToForget);
            System.out.println("nbPeopleDelayedPerDay "+ nbPeopleDelayedPerDay);*/

        }
        return nbPeopleWithSecret.mod(BigInteger.valueOf(1000000007L)).intValue();
    }
}
