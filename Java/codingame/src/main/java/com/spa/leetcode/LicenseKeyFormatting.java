package com.spa.leetcode;

public class LicenseKeyFormatting {

    //https://leetcode.com/problems/license-key-formatting/submissions/1189528454/
    public String licenseKeyFormatting(String s, int k) {
       String key = String.join("", s.toUpperCase().split("-"));
       StringBuilder reformattedKey = new StringBuilder();
       int firstpart = key.length()  % k ;
       reformattedKey.append(key, 0, firstpart);
        for (int i = firstpart; i + k <= key.length()  ; i+= k) {
            if(!reformattedKey.isEmpty()){
                reformattedKey.append("-");
            }
            reformattedKey.append(key, i, i + k);
        }
        return reformattedKey.toString();
    }
}
