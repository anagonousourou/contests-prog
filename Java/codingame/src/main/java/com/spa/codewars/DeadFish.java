package com.spa.codewars;


import java.util.ArrayList;
import java.util.List;

public class DeadFish {
    public static int[] parse(String data) {
        int v = 0;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            switch (data.charAt(i)){
                case 'i':
                    v++;
                    break;
                case 'd':
                    v--;
                    break;
                case 's':
                    v = v*v;
                    break;
                case 'o':
                    values.add(v);
                    break;
            }
        }
        return  values.stream().mapToInt(Integer::intValue).toArray();
    }
}
