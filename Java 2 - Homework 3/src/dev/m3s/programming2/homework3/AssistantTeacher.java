package dev.m3s.programming2.homework3;

import java.util.ArrayList;

public class AssistantTeacher extends Employee implements Teacher, Payment{


    //**********    ATTRIBUTES/PARAMETERS
    //***********************************


    ArrayList<DesignatedCourse> courses = new ArrayList<>();



    //**********    CONSTRUCTOR
    //***********************************

    public AssistantTeacher(String lname, String fname) {

        super(lname, fname);
    }



    //**********    METHODS
    //***********************************Em


    public String getEmployeeIdString()  {

        String temppistr2 = "OY_ASSISTANT_";

        return temppistr2;

    }


    @Override
    public String getCourses() {

        // utilize DesignatedCourse-class toString()-method
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
        return "AssistantTeacher{" +
                "courses=" + courses +
                '}';
    }
}
