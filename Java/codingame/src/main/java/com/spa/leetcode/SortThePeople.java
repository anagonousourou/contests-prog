package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SortThePeople {


    //https://leetcode.com/problems/sort-the-people/
    private record Person(String name, int height) {
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> people = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        people.sort(Comparator.comparingInt(Person::height).reversed());
        return people.stream().map(Person::name).toArray(String[]::new);
    }
}
