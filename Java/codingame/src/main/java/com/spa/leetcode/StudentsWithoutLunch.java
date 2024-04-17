package com.spa.leetcode;

public class StudentsWithoutLunch {
    //https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/submissions/1226591247/
    public int countStudents(int[] students, int[] sandwiches) {
        int nbStudentsPreferringCirculars = 0;
        int nbStudentsPreferringSquares = 0;

        for (int student: students){
            if(student == 0){
                nbStudentsPreferringCirculars++;
            }else{
                nbStudentsPreferringSquares++;
            }
        }
        for (int sandwich : sandwiches){
            if(sandwich == 0 && nbStudentsPreferringCirculars > 0){
                nbStudentsPreferringCirculars--;
            }
            else if(sandwich == 1 && nbStudentsPreferringSquares > 0){
                nbStudentsPreferringSquares--;
            }else{
                return nbStudentsPreferringCirculars + nbStudentsPreferringSquares;
            }
        }
        return 0;
    }
}
