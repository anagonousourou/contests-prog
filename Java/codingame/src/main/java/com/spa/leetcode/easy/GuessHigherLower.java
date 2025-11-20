package com.spa.leetcode.easy;

public class GuessHigherLower {


    // https://leetcode.com/problems/guess-number-higher-or-lower/submissions/1688326829/

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            long low = 0;
            long high = n;

            while (true){
                if(low == high){
                    return (int) low;
                }
                else if(low + 1 == high){
                    if(guess((int) low) == 0){
                        return (int) low;
                    }else{
                        return (int) high;
                    }
                }else{
                    int middle = (int) ((low + high) / 2);
                    if(guess(middle)  == 1){
                        low = middle;
                    }else if(guess(middle) == -1){
                        high = middle;
                    }else{
                        return middle;
                    }
                }
            }
        }
    }

    private  class GuessGame {

        /**
         * Forward declaration of guess API.
         * @param  num   your guess
         * @return 	     -1 if num is higher than the picked number
         *			      1 if num is lower than the picked number
         *               otherwise return 0
         * int guess(int num);
         */

        public int guess(int num){
            return Integer.compare(1702766719, num);
        }
    }
}
