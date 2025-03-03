package com.spa.leetcode.easy;

public class NumberOfLines {

    // https://leetcode.com/problems/number-of-lines-to-write-string/submissions/1529066376/
    public int[] numberOfLines(int[] widths, String s) {
        int nbLines = 1;
        int curentLineLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(curentLineLength + widths[s.charAt(i) - 'a'] > 100){
                nbLines++;
                curentLineLength = widths[s.charAt(i) - 'a'];
            }
            else if(curentLineLength + widths[s.charAt(i) - 'a'] == 100 && i == s.length() - 1){
                curentLineLength += widths[s.charAt(i) - 'a'];
                break;
            }
            else if(curentLineLength + widths[s.charAt(i) - 'a'] == 100 ){
                nbLines++;
                curentLineLength = 0;
            }
            else{
                curentLineLength += widths[s.charAt(i) - 'a'];
            }
        }
        return new int[] {nbLines, curentLineLength};
    }
}
