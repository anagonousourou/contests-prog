package com.spa.hackerrank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaBigDecimal {

    public static class MyNumber{
        final String input;
        final BigDecimal value;
        public MyNumber(String input, BigDecimal value){
            this.input = input;
            this.value = value;
        }

        public BigDecimal getValue() {
            return value;
        }

        public String getInput() {
            return input;
        }
    }

    public static void main(String[] args) {
        List<MyNumber> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();//ignore
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            numberList.add(new MyNumber(line, new BigDecimal(line)));
        }
        scanner.close();

        numberList.sort(Comparator.comparing(MyNumber::getValue).reversed());
        numberList.forEach(myNumber -> System.out.println(myNumber.input));
    }
}
