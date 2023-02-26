package com.spa.codewars;

import com.spa.commonfns.StringHelpers;

import java.util.HashMap;
import java.util.Map;


public class UrlShortener {

    Map<String, String> databases = new HashMap<>();
    Map<String, String> longToShortDb = new HashMap<>();

    char [] nextAddress = new char[] {' ', ' ' ,' ', 'a'};

    public String urlShortener(String longURL) {
        if (longToShortDb.containsKey(longURL)) {
            return longToShortDb.get(longURL);
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            String h = "short.ly/" +  stringBuilder.append(nextAddress).toString().trim();
            incrementAddress(nextAddress);
            databases.put(h, longURL);
            longToShortDb.put(longURL, h);
            return h;
        }
    }

    public String urlRedirector(String shortURL) {
        return databases.get(shortURL);
    }

    public static void incrementAddress(char [] address){
        for (int i = address.length -1; i >= 0; i--) {
            if(address[i] >= 97 && address[i] < 122){
                address[i]++;
                break;
            }
            else if(address[i] == 'z'){
                address[i] = 'a';
            }
            else if(address[i] == ' '){
                address[i]= 'a';
                break;
            }
        }
    }
}
