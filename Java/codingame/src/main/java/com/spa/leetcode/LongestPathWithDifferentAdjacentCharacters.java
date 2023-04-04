package com.spa.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPathWithDifferentAdjacentCharacters {
    public int longestPath(int[] parent, String s) {
        return 0;
    }

    /**
     * d -> b
     * {a => {a, b}, b => {a,b} , d => {e, d}, e => {e, d},  }
     * @param s1
     * @param s2
     * @param baseStr
     * @return
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character , Set<Character>> equivalenceMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            var set1 = equivalenceMap.getOrDefault(s1.charAt(i), new HashSet<>());
            var set2 = equivalenceMap.getOrDefault(s2.charAt(i), new HashSet<>());
            var eqSet = new HashSet<Character>();
            eqSet.addAll(set1);
            eqSet.addAll(set2);
            eqSet.add(s1.charAt(i));
            eqSet.add(s2.charAt(i));
            for(Character ch : eqSet){
                equivalenceMap.put(ch, eqSet);
            }
        }

        System.out.println(equivalenceMap);

        String result = "";
        for (int i = 0; i < baseStr.length(); i++) {
            if(equivalenceMap.containsKey(baseStr.charAt(i))){
                result += equivalenceMap.get(baseStr.charAt(i)).stream().min(Character::compareTo).get();
            }
            else{
                result += baseStr.charAt(i);
            }
        }
        return result;
    }
}
