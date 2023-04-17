package dev.m3s.programming2.homework3;

import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher, Payment {

    private List<DesignatedCourse> courses = new ArrayList<>();


    public  ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }


    public String getEmployeeIdString()  {
        return "OY_TEACHER_";
    }


    @Override
    public String getCourses() {
        String temppi = "";

        for (DesignatedCourse dc : courses ) {
            temppi += "\t\t" + printResponsibleStatus(dc.isResponsible()) +
                    "[course=" + dc.getCourse() +
                    ", year=" + dc.getYear() + "]" + "\n";
        }
        return temppi;
    }


    public String printResponsibleStatus(boolean isResponsible) {
        if (isResponsible) {
            return "Responsible teacher: ";
        }
        return "Teacher: ";
    }


    public void setCourses(List<DesignatedCourse> courses) {
        if (courses!= null) {
            this.courses = courses;
        }
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
                tab + tab + "Teacher for courses: " + printL +
                getCourses();
    }
}
