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


    public String printAssistanCourses() {

        String temppi = "";

        for (DesignatedCourse dc : courses ) {
            temppi += "\t\t" + "[course=" + dc.getCourse() +
                    ", year=" + dc.getYear() + "]" + "\n";
        }

        return temppi;
    }



    @Override
    public String toString() {
        String tab = "\t";
        String printL = "\n";

        return "Teacher id: " + getEmployeeIdString() +
                getIdString()               + printL +
                tab + tab + "FirstName: " + getFirstName() + ", " +
                "LastName: " + getLastName()+ printL +
                tab + tab + "Birthdate: " + getBirthdate() + printL +
                tab + tab + "Salary: " + getPayment().calculatePayment() + printL +
                tab + tab + "Teacher for courses: " + printL +
                printAssistanCourses();
    }


}
