package dev.m3s.programming2.homework2;

import java.time.Year;

public class StudentCourse {

    // **** ATTRIBUTES
    // ******************************

    Course course;
    private int gradeNum;
    private int yearCompleted;


    // **** CONSTRACTORS
    // ******************************

    public StudentCourse() {

    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {

        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    // **** METHODIT
    // ******************************


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGradeNum() {
        return this.gradeNum;
    }

    // Set to PROTECTED
    public void setGrade(int gradeNum) {


        if (checkGradeValidity(gradeNum)) {
            if ((gradeNum == 'F') || (gradeNum == 'A')) {
                char gradeNumChar = (char) gradeNum;

                this.gradeNum = gradeNumChar;
            } else {
                this.gradeNum = gradeNum;
            }
        }

        // jos yearCompleted ei ole set -> tämä vuosi
        // eli jos on 0
        if (yearCompleted == 0) {
            this.yearCompleted = getCurrentYear();
        }

    }


    // muista muuttaa privaatiksi
    public boolean checkGradeValidity(final int gradeNum) {
        boolean isValid = gradeNum >= 0 && gradeNum <= 5;

        char gradeNumChar = (char) gradeNum;

        if ((gradeNumChar == 'F') || (gradeNumChar == 'A')) {
            isValid = true;
        }

        return isValid;
    }


    public boolean isPassed() {
        boolean isPassed = true;

        if (gradeNum == 0) {
            isPassed = false;
        }

        char gradeNumChar = (char) gradeNum;

        if (gradeNumChar == 'F') {
            isPassed = false;
        }

        return isPassed;
    }


    public int getYear() {
        return yearCompleted;
    }


    public void setYear(int yearCompleted) {
        if (yearCompleted >= 2000 &&
                yearCompleted <= getCurrentYear()) {

            this.yearCompleted = yearCompleted;
        }
    }

    public int getCurrentYear() {
        return Year.now().getValue();
    }

    public String printGrade() {

        String gradeStr = null;
        if (gradeNum == 65) {
            return "A";
        } else if (gradeNum == 70) {
            return "F";
        } else if (gradeNum == 0) {
            return "\"Not Graded\"";
        }
        gradeStr = Integer.toString(gradeNum);
        return gradeStr;
    }


    @Override
    public String toString() {
        return course +
                " Year: " + yearCompleted +
                ", Grade: " + printGrade() + ".] ";
    }
}