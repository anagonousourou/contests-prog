package com.spa.leetcode.easy;

public class ExcelSheetTitle {

    // https://leetcode.com/problems/excel-sheet-column-title/submissions/1545057629/
    public String convertToTitle(int columnNumber) {
        if(columnNumber == 0){
            return "";
        }else if(columnNumber >= 1 && columnNumber <= 26){
            return String.valueOf((char)('A' + columnNumber - 1));
        }else{
            if(columnNumber % 26 == 0){
                return convertToTitle((columnNumber - 1) / 26) + convertToTitle(26);
            }
            return convertToTitle(columnNumber / 26) + convertToTitle(columnNumber % 26);
        }
    }

}
