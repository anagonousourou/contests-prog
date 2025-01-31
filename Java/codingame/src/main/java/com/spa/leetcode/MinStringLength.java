package com.spa.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStringLength {

    //https://leetcode.com/problems/minimum-string-length-after-removing-substrings/submissions/1231399558/
    public int minLength(String s) {
        Deque<Character> characters = new LinkedList<>();

        for(char c : s.toCharArray()){
            if(c == 'B' && !characters.isEmpty() && characters.peek() == 'A'){
                characters.pop();
            }
            else if(c == 'D' && !characters.isEmpty() && characters.peek() == 'C'){
                characters.pop();
            }else{
                characters.push(c);
            }
        }
        return characters.size();
    }
}
