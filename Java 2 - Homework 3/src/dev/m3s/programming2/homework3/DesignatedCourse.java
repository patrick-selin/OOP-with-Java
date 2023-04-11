package dev.m3s.programming2.homework3;

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

        this.course = course;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }
}
