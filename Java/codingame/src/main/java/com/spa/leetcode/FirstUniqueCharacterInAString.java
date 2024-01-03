package com.spa.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    //https://leetcode.com/problems/first-unique-character-in-a-string
    private class CharacterInfo {
        private int occ = 1;
        private int index = 0;
        CharacterInfo(int index){
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public int firstUniqChar(String s) {
        char[] schars = s.toCharArray();
        Map<Character, CharacterInfo> characterInfoMap = new HashMap<>();
        for (int i = 0; i < schars.length; i++) {
            if(characterInfoMap.containsKey(schars[i])){
                characterInfoMap.get(schars[i]).occ += 1;
            }else{
                characterInfoMap.put(schars[i], new CharacterInfo(i));
            }
        }
        return characterInfoMap.values().stream().filter(info -> info.occ == 1).min(Comparator.comparingInt(CharacterInfo::getIndex))
            .map(CharacterInfo::getIndex).orElse(-1);
    }
}
