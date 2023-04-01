package com.spa.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllBalancedParentheses {

    public record Paren(String value, int nbOpenned, int nbRemPairToOpen){}

    public static List<Paren> generateNext(Paren paren){
        List<Paren> result = new ArrayList<>();
        if(paren.nbOpenned() > 0){
            result.add(new Paren(paren.value()+")", paren.nbOpenned() - 1, paren.nbRemPairToOpen()));
        }
        if(paren.nbRemPairToOpen() > 0){
            result.add(new Paren(paren.value()+"(", paren.nbOpenned() + 1, paren.nbRemPairToOpen() - 1));
        }
        if(paren.nbRemPairToOpen() == 0 && paren.nbOpenned() == 0){
            result.add(paren);
        }
        return result;
    }

    public static List <String> balancedParens (int n) {
        List<Paren> notFinished = new ArrayList<>();
        List<Paren> balancedParens = new ArrayList<>();
        notFinished.add(new Paren("", 0, n));
        do {
            List<Paren> nextSteps = generateNext(notFinished.remove(0));
            balancedParens.addAll(nextSteps.stream().filter(p -> p.nbOpenned() == 0 && p.nbRemPairToOpen() == 0).toList());
            notFinished.addAll(nextSteps.stream().filter(p -> p.nbOpenned() != 0 || p.nbRemPairToOpen() != 0).toList());
            System.out.println("Balanced :"+ balancedParens.size());
            System.out.println("UnBalanced :"+ notFinished.size());
        }while (!notFinished.isEmpty());

         return  balancedParens.stream().map(Paren::value).collect(Collectors.toList());
    }
}
