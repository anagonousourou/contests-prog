package com.spa.leetcode;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int j = 0;
        int i = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]){
                j++;
                i++;
                count++;
            } else{
                j++;
            }
        }
        return count;
    }
}
