package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class Degree {

    static final int MAX_COURSES = 50;
    private int count = 0;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();


    public List<StudentCourse> getCourses() {
        return myCourses;
    }


    public void addStudentCourses(List<StudentCourse> courses){
        if (courses != null ) {
            for (StudentCourse course : courses) {
                if (course != null && count < MAX_COURSES) {
                    addStudentCourse(course);
                }
            }
        }
    }


    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && count < MAX_COURSES) {
            myCourses.add(course);
            this.count++;

            return true;
        }
        return false;
    }


    public String getDegreeTitle() {
        return degreeTitle;
    }


    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }


    public String getTitleOfThesis() {
        return titleOfThesis;
    }


    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }


    public double getCreditsByBase(Character base) {
        double totalCreditsByBase = 0.00;

        for (StudentCourse course: myCourses) {
            if (course != null &&
                    base == course.getCourse().getCourseBase()) {

                double credits = course.getCourse().getCredits();

                if (isCourseCompleted(course)) {
                    totalCreditsByBase += credits;
                }
            }
        }
        return totalCreditsByBase;
    }


    public double getCreditsByType(int courseType) {
        double totalCreditsByType = 0.00;

        for (StudentCourse course: myCourses) {
            if (course != null &&
                courseType == course.getCourse().getCourseType()) {

                double credits = course.getCourse().getCredits();

                if (isCourseCompleted(course)) {
                    totalCreditsByType += credits;
                }
            }
        }
        return totalCreditsByType;
    }


    public double getCredits() {
        double totalCredits = 0.00;

        for (StudentCourse course: myCourses)  {
            if (course != null) {
                double credits = course.getCourse().getCredits();

                if (isCourseCompleted(course)) {
                    totalCredits += credits;
                }
            }
        }
        return totalCredits;
    }


    private boolean isCourseCompleted(StudentCourse c) {
        boolean courseCompleted = false;

        if (c != null) {
            if (c.getCourse().isNumericGrade()) {
                if (c.getGradeNum() > ConstantValues.MIN_GRADE ){

                    courseCompleted = true;
                }
            } else {
                if ( (c.getGradeNum() == ConstantValues.GRADE_ACCEPTED ||
                        c.getGradeNum() == 'a')) {

                    courseCompleted = true;
                }
            }
        }

        return courseCompleted;
    }


    public void printCourses() {
        for (StudentCourse course: myCourses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }


    public List<Double> getGPA (int type) {
        ArrayList<Double> listGPA= new ArrayList<>();

        double sum = 0.00;
        double count = 0.00;

        for (StudentCourse c : myCourses) {
            if (c.getCourse().isNumericGrade()) {
                sum += c.getGradeNum();
                count++;
            }
        }

        listGPA.add(sum);
        listGPA.add(count);
        double avg = sum / count;
        listGPA.add(avg);

        return listGPA;
    }


    private String printDegreeCourses() {
        int counter = 1;
        String printStr = "";
        for (StudentCourse course: myCourses) {
            if (course != null) {

                printStr += "\t" + counter + ". " + course + "\n";
                counter++;
            }
        }
        return printStr;
    }


    @Override
    public String toString() {
        return "Degree [Title: \"" + degreeTitle +
                "\" (courses: " + count +  ")\n" +
                "\tThesis title: \"" + titleOfThesis + "\"" +
                "\n" + printDegreeCourses()
                ;
    }
}
