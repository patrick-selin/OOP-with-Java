package dev.m3s.programming2.homework3;

import java.time.Year;
import java.util.ArrayList;

public class DesignatedCourse {

    //**********    ATTRIBUTES/PARAMETERS
    //***********************************


    Course course;
    private boolean responsible;
    private int year;



    //**********    CONSTRUCTOR
    //***********************************


    public DesignatedCourse() {

    }


    public DesignatedCourse(Course course, boolean responsible, int year) {
        setCourse(course);
        setResponsible(responsible);
        setYear(year);
    }

    //**********    METHODS
    //***********************************


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    public boolean isResponsible() {
        return responsible;
    }


    public boolean getResponsible() {
        return responsible;
    }

    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    public int getCurrentYear() {
        return Year.now().getValue();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= ConstantValues.MIN_START_YEAR &&
            year <= getCurrentYear() + 1) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return  "[course=" + course +
                ", year=" + year +
                ']';
    }
}
