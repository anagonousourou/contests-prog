package com.spa.codewars;

public class ValidParentheses {

    public static boolean validParentheses(String parens)
    {
        int count = 0;
        for(char ch :parens.toCharArray()){
            if( ch == '('){
                count++;
            }
            if(ch == ')'){
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
}
