package com.spa.leetcode.medium;

import java.util.BitSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ExclusiveTimeOfFunctions {

    // https://leetcode.com/problems/exclusive-time-of-functions/submissions/1842484669/

    record Execution(int functionId, String event, int timestamp){

    }

    public int[] exclusiveTime(int n, List<String> logs){
        Pattern logPattern = Pattern.compile("(\\d+):(start|end):(\\d+)");
        int[] exclusiveExecutionTimes = new int[n];
        Deque<Execution> startEvents = new LinkedList<>();
        List<Execution> executions = logs.stream().flatMap(log -> {
            var matcher = logPattern.matcher(log);
            if(matcher.find()){
                return Stream.of(new Execution(Integer.parseInt(matcher.group(1)), matcher.group(2), Integer.parseInt(matcher.group(3))));
            }else{
                return Stream.of();
            }
        }).toList();

        BitSet bitSet = new BitSet(executions.getLast().timestamp + 1);


        for(Execution execution: executions){
            if("start".equals(execution.event)){
                startEvents.push(execution);
            }else{
                Execution startEvent = startEvents.pop();
                int count = bitSet.get(startEvent.timestamp, execution.timestamp + 1).cardinality();
                bitSet.set(startEvent.timestamp, execution.timestamp + 1);
                exclusiveExecutionTimes[execution.functionId] += (execution.timestamp - startEvent.timestamp + 1 - count);
            }
        }

        return exclusiveExecutionTimes;
    }
}
