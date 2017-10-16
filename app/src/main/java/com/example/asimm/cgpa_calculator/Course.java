package com.example.asimm.cgpa_calculator;

/**
 * Created by asimm on 9/26/2017.
 */

public class Course {

    private String grade;
    private int credit;

    public Course(String grade, int credit){
        this.grade = grade;
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
