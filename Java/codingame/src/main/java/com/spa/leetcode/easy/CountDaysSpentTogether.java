package com.spa.leetcode.easy;

import java.time.LocalDate;
import java.util.stream.Stream;

public class CountDaysSpentTogether {


    // https://leetcode.com/problems/count-days-spent-together/submissions/2050473823/
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
       LocalDate bobStart = LocalDate.parse("2026-"+arriveBob);
       LocalDate bobEnd = LocalDate.parse("2026-"+leaveBob);
       LocalDate aliceStart = LocalDate.parse("2026-"+arriveAlice);
       LocalDate aliceEnd = LocalDate.parse("2026-"+leaveAlice);

       LocalDate earliest = Stream.of(bobStart, bobEnd, aliceStart, aliceEnd).min(LocalDate::compareTo).orElseThrow();
       LocalDate latest = Stream.of(bobStart, bobEnd, aliceStart, aliceEnd).max(LocalDate::compareTo).orElseThrow();

       LocalDate current = earliest;

       int count = 0;
       while (isBeforeOrEqual(current, latest)){
           if(isAfterOrEqual(current, bobStart) && isBeforeOrEqual(current, bobEnd) && isAfterOrEqual(current, aliceStart) && isBeforeOrEqual(current, aliceEnd)){
               count++;
           }
           current = current.plusDays(1);
       }

       return count;
    }

    private boolean isBeforeOrEqual(LocalDate candidate, LocalDate fixed){
        return candidate.isBefore(fixed) || candidate.isEqual(fixed);
    }

    private boolean isAfterOrEqual(LocalDate candidate, LocalDate fixed){
        return candidate.isAfter(fixed) || candidate.isEqual(fixed);
    }
}
