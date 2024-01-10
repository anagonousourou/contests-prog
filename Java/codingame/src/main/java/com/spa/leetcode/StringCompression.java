package com.spa.leetcode;

public class StringCompression {

    //https://leetcode.com/problems/string-compression/
    public int compress(char[] chars) {
        int writerPos = 0;
        int readerPos = 0;
        while (readerPos < chars.length){
            int count = 0;
            int currentPos = readerPos;
            while (readerPos < chars.length && chars[readerPos] == chars[currentPos]){
                readerPos++;
                count++;
            }
            if(count == 1){
                chars[writerPos] = chars[currentPos];
                writerPos++;
            }else{
                chars[writerPos] = chars[currentPos];
                writerPos++;
                var countArray = String.valueOf(count).toCharArray();
                System.arraycopy(countArray, 0, chars, writerPos, countArray.length);
                writerPos+= countArray.length;
            }
        }
        return writerPos;
    }
}
