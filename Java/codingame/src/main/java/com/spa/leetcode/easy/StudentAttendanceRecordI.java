package com.spa.leetcode.easy;

public class StudentAttendanceRecordI {


    // https://leetcode.com/problems/student-attendance-record-i/submissions/1430418876/
    public boolean checkRecord(String s) {
        int nbAbsence = 0;
        int nbLates = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                nbAbsence++;
            }
            if (s.charAt(i) == 'L') {
                nbLates++;
            } else {
                nbLates = 0;
            }
            if (nbLates >= 3 || nbAbsence >= 2) {
                return false;
            }
        }
        return true;
    }
}
