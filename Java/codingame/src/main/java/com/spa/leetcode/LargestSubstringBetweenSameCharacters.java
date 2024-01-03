package com.spa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenSameCharacters {
    //https://leetcode.com/problems/largest-substring-between-two-equal-characters/

    private record Positions(int minPos, int maxPos){

        Positions withMinPos(int newMinPos){
            return new Positions(newMinPos, maxPos);
        }

        Positions withMaxPos(int newMaxPos){
            return new Positions(minPos, newMaxPos);
        }
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Positions> characterPositionsMap = new HashMap<>(s.length());
        for (int i = 0; i < chars.length; i++) {
            if(characterPositionsMap.containsKey(chars[i])){
                characterPositionsMap.put(chars[i], characterPositionsMap.get(chars[i]).withMaxPos(i));
            }else{
                characterPositionsMap.put(chars[i], new Positions(i, i));
            }
        }
        return characterPositionsMap.values().stream().mapToInt(positions -> positions.maxPos - positions.minPos)
            .max().getAsInt() - 1;
    }

}
