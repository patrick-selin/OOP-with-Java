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
        // if course is graded numeric or alphabet

        // if num -> pitää olla 0to5 = käytä checkGradeValiditity

        // in alpabet -> pitää olla 'F' tai 'A'

        // ja jos yearCompleted() ei ole asetettu, set to Current Year


        this.gradeNum = gradeNum;
    }


    // kesken
    public boolean isPassed() {
        boolean joo = true;

        return joo;

    }

    public int getYear() {
        return yearCompleted;
    }

    public void setYear(int yearCompleted) {
        if (yearCompleted >=2000 &&
            yearCompleted <= getCurrentYear() ) {
            System.out.println(getCurrentYear());
            this.yearCompleted = yearCompleted;
        }
    }

    public int getCurrentYear() {
        return Year.now().getValue();
    }
}
