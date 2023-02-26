package com.spa.codewars;

import java.util.regex.Pattern;

public class NotVerySecure {

    public static boolean alphanumeric(String s){
        return Pattern.matches("\\p{Alnum}+",s);
    }
}
