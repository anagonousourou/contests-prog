package com.spa.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    // https://leetcode.com/problems/isomorphic-strings/submissions/831305282/

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic(s, t, new HashMap<>());
    }

       public boolean isIsomorphic(String s, String t, Map<String, String> transformations) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        String currentSLetter = s.substring(0, 1);
        String currentTLetter = t.substring(0, 1);

        if(transformations.containsKey(currentSLetter) && !transformations.get(currentSLetter).equals(currentTLetter)){
            return false;
        }


        if(!transformations.containsKey(currentSLetter) && !transformations.containsValue(currentTLetter)){
            transformations.put(currentSLetter, currentTLetter);
        }
        if(!transformations.containsKey(currentSLetter) && transformations.containsValue(currentTLetter)){
            return false;
        }
        return isIsomorphic(s.substring(1), t.substring(1), transformations);
    }
}
