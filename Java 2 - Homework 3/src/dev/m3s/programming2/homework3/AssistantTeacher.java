package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class AssistantTeacher extends Employee implements Teacher, Payment{

    private List<DesignatedCourse> courses = new ArrayList<>();


    public AssistantTeacher(String lname, String fname) {
        super(lname, fname);
    }


    public String getEmployeeIdString()  {
        return "OY_ASSISTANT_";

    }


    @Override
    public String getCourses() {
        // utilize DesignatedCourse-class toString()-method
        String temppistr = "Tää on temppi kurssidatasta";


        return temppistr;
    }

    public void setCourses(List<DesignatedCourse> courses) {
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
                tab + tab + "Birthdate: " + getBirthDate() + printL +
                tab + tab + "Salary: " + getPayment().calculatePayment() + printL +
                tab + tab + "Assistant for courses: " + printL +
                printAssistanCourses();
    }
}
