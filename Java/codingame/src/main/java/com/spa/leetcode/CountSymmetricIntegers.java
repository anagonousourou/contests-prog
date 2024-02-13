package com.spa.leetcode;

public class CountSymmetricIntegers {

    //https://leetcode.com/problems/count-symmetric-integers/description/
    public int countSymmetricIntegers(int low, int high) {
        int nb = 0;
        for (int i = low; i <= high ; i++) {
            String istr = String.valueOf(i);
            if(istr.length() % 2 == 0
                && istr.substring(0, istr.length() / 2).chars().map(Character::getNumericValue).sum() == istr.substring(istr.length() / 2).chars().map(Character::getNumericValue).sum()){
                nb++;
            }
        }
        return nb;
    }
}
