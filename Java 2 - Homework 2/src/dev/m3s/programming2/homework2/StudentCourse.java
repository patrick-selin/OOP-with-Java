package dev.m3s.programming2.homework2;

import java.time.Year;

public class StudentCourse {

    private Course course;
    private int gradeNum;
    private int yearCompleted;


    public StudentCourse() {
    }


    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }


    public Course getCourse() {
        return course;
    }


    public void setCourse(Course course) {
        this.course = course;
    }


    public int getGradeNum() {
        return gradeNum;
    }


    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum)) {
            if (!course.isNumericGrade()) {

                if ((gradeNum == ConstantValues.GRADE_FAILED) ||
                        (gradeNum == ConstantValues.GRADE_ACCEPTED)) {

                    this.gradeNum = (char) gradeNum;
                }

            } else {
                this.gradeNum = gradeNum;
            }
        }

        if (yearCompleted == 0) {
            this.yearCompleted = getCurrentYear();
        }
    }


    private boolean checkGradeValidity(final int gradeNum) {
        if (course.isNumericGrade()) {
            if (gradeNum >= ConstantValues.MIN_GRADE &&
                gradeNum <= ConstantValues.MAX_GRADE) {

                return true;
            }

        } else {

            char gradeNumChar = (char) gradeNum;

            if ((gradeNumChar == 'A') ||
                (gradeNumChar == 'F')) {

            return true;
            }
        }

        return false;
    }


    public boolean isPassed() {
        boolean isPassed = gradeNum != ConstantValues.MIN_GRADE;

        char gradeNumChar = (char) gradeNum;

        if (gradeNumChar == ConstantValues.GRADE_FAILED) {
            isPassed = false;
        }

        return isPassed;
    }

    public int getYear() {
        return yearCompleted;
    }


    public void setYear(int yearCompleted) {
        if (yearCompleted >= ConstantValues.MIN_START_YEAR &&
                yearCompleted <= getCurrentYear()) {

            this.yearCompleted = yearCompleted;
        }
    }

    public String printGrade() {

        String gradeStr = null;

        if (gradeNum == 65) return "A";

        else if (gradeNum == 70) {
            return "F";
        }
        else if (gradeNum == 0) {
            return "\"Not Graded\"";
        }

        gradeStr = Integer.toString(gradeNum);
        return gradeStr;
    }


    public int getCurrentYear() {
        return Year.now().getValue();
    }

    @Override
    public String toString() {
        return course + " Year: " + yearCompleted +
                ", Grade: " + printGrade() + ".]";

    }
}