package dev.m3s.programming2.homework3;

import java.util.ArrayList;

public class ResponsibleTeacher extends Employee implements Teacher, Payment {


    //**********    ATTRIBUTES/PARAMETERS
    //***********************************


    ArrayList<DesignatedCourse> courses = new ArrayList<>();



    //**********    CONSTRUCTOR
    //***********************************

    public  ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }


    //**********    METHODS
    //***********************************


    public String getEmployeeIdString()  {

        String temppistr2 = "OY_TEACHER_";

        return temppistr2;

    }


    @Override
    public String getCourses() {

        // KESKEN
        String temppistr = "Tää on temppi kurssidatasta";

        return temppistr;
    }

    public void setCourses(ArrayList<DesignatedCourse> courses) {

        if (courses!= null) {
            this.courses = courses;
        }
    }


    @Override
    public String toString() {
        return "ResponsibleTeacher{" +
                "courses=" + courses +
                '}' + getLastName() + " " + getFirstName();
    }



}
