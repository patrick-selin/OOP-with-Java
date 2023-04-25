package dev.m3s.programming2.homework3;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private int id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
    private int startYear = getCurrentYear();
    private int graduationYear;
    private final List<Degree> degrees = new ArrayList<>();


    public Student(String lastName, String firstName) {
        super(lastName,firstName);
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
    }


    public int getId() {
        return id;
    }


    public void setId(final int id) {
        int min = ConstantValues.MIN_STUDENT_ID;
        int max = ConstantValues.MAX_STUDENT_ID;
        if (id >= min && id <= max) {
            this.id = id;
        }
    }


    public int getCurrentYear() {
        return Year.now().getValue();
    }


    public int getStartYear() {
        return startYear;
    }


    public void setStartYear(final int startYear) {
        if (startYear > ConstantValues.MIN_START_YEAR &&
                startYear <= getCurrentYear()) {
            this.startYear = startYear;
        }
    }


    public int getGraduationYear() {
        return graduationYear;
    }


    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() &&
                graduationYear >= this.startYear &&
                graduationYear <= getCurrentYear() ){
            this.graduationYear = graduationYear;
            return "Ok";
        }
        else if (!canGraduate()) {
            return "Check amount of required credits";
        }
        else {
            return "Check graduation year";
        }
    }


    public void setDegreeTitle(final int i, String dName) {
        if (dName != null && i >= 0 && i < degrees.size()) {
            degrees.get(i).setDegreeTitle(dName);
        }
    }


    public boolean addCourse(final int i, StudentCourse course) {
        boolean onko = false;


        if (course != null &&
                i >= 0 &&
                i <= degrees.size() &&
                degrees.get(i).getCourses().size() <= degrees.get(i).MAX_COURSES) {

            degrees.get(i).addStudentCourse(course);
            onko = true;
        }

        return onko;
    }


    public int addCourses(final int i, List<StudentCourse> courses) {
        int numAddedCourses = 0;

        if (courses != null && i >= 0 && i < degrees.size()) {


            for (StudentCourse c: courses) {
                if ( c != null && degrees.get(i).addStudentCourse(c)) {
                    numAddedCourses++;
                }
            }
        }
        return numAddedCourses;
    }


    public void printCourses() {
        for (Degree dd : degrees) {
            if (dd != null) {

                for (StudentCourse c : dd.getCourses()) {
                    if (c != null)
                        System.out.println(c);
                }
                System.out.println();
            }
        }
    }


    public void printDegrees() {
        for (Degree dd : degrees) {
            System.out.println(dd.toString());
        }

    }


    public void setTitleOfThesis(int i, String title) {
        if (title != null && i >= 0 && i < degrees.size()) {
            degrees.get(i).setTitleOfThesis(title);
        }
    }


    public boolean hasGraduated() {
        return canGraduate() &&
                graduationYear != 0 &&
                graduationYear >= startYear &&
                graduationYear <= getCurrentYear();
    }


    private boolean canGraduate() {
        if (!(degrees.get(ConstantValues.BACHELOR_TYPE).
                getCreditsByType(ConstantValues.MANDATORY) >=
                ConstantValues.BACHELOR_MANDATORY) &&

           !(degrees.get(ConstantValues.BACHELOR_TYPE).getCredits() >=
                ConstantValues.BACHELOR_CREDITS)) {

            return false;
        }


        if (!(degrees.get(ConstantValues.MASTER_TYPE).
                getCreditsByType(ConstantValues.MANDATORY) >=
                ConstantValues.MASTER_CREDITS) &&

            !(degrees.get(ConstantValues.MASTER_TYPE).getCredits() >=
                ConstantValues.MASTER_CREDITS)) {

            return false;
        }

        if (!(degrees.get(ConstantValues.MASTER_TYPE).getTitleOfThesis() != null &&
                !degrees.get(ConstantValues.MASTER_TYPE).getTitleOfThesis().equals(ConstantValues.NO_TITLE)
        )) {
            return false;
        }

        if (!(degrees.get(ConstantValues.BACHELOR_TYPE).getTitleOfThesis() != null &&
                !degrees.get(ConstantValues.BACHELOR_TYPE).getTitleOfThesis().equals(ConstantValues.NO_TITLE)
        )) {
            return false;

        }
        return true;
    }


    public int getStudyYears() {
        if (hasGraduated()) {
            return getGraduationYear() - this.startYear;
        }

        return getCurrentYear() - this.startYear;
    }


    public String getIdString() {

        String IdString = "Student id: " + this.id;

        return IdString;
    }


    private String statusPrinter() {
        if (hasGraduated()) {
            return "The student has graduated in " + graduationYear;
        }
        else {
            return "The student has not graduated, yet.";
        }
    }


    public double getAllCredits() {
        return degrees.get(ConstantValues.BACHELOR_TYPE).getCredits() +
               degrees.get(ConstantValues.MASTER_TYPE).getCredits();

    }


    public String printCredits(int degree) {
        if (degree == ConstantValues.BACHELOR_TYPE) {
            if ( degrees.get(ConstantValues.BACHELOR_TYPE).getCredits()
                    >= ConstantValues.BACHELOR_CREDITS) {
                return "Total bachelor credits completed";
            }
            else return "Missing bachelor's credits " +
                    (ConstantValues.BACHELOR_CREDITS -
                            degrees.get(ConstantValues.BACHELOR_TYPE).getCredits());
        }
        if ( degrees.get(ConstantValues.MASTER_TYPE).getCredits() >= ConstantValues.MASTER_CREDITS) {
            return "Total master's credits completed";
        }
        else return "Missing master's credits  " +
                (ConstantValues.MASTER_CREDITS - degrees.get(ConstantValues.MASTER_TYPE).getCredits());
    }


    public String printMandatoryCredits(int degree) {

        if (degree == ConstantValues.BACHELOR_TYPE) {
        return "All mandatory bachelor credits completed (" +
                degrees.get(0).getCreditsByType(1);

        } else return "All mandatory master credits completed (" +
                degrees.get(1).getCreditsByType(1);
    }

    public Double countGPA() {
        double gpaAvg = 0.00;

        gpaAvg = (degrees.get(0).getGPA(2).get(2) +
                degrees.get(1).getGPA(2).get(2)) / 2;

        return gpaAvg;
    }


    @Override
    public String toString() {
        String tab = "\t";
        String printL = "\n";

        return "Student id: " + id + printL +
                tab + "FirstName: " + getFirstName() + ", " +
                "LastName: " + getLastName()+ printL +
                tab + "Date of birth: " + getBirthDate() + printL +
                tab + "Status: " + statusPrinter() + printL +
                tab + "Start year: " + startYear + " (studies have lasted for " +
                getStudyYears() + " years)" + printL +

                tab + "Total credits: " + getAllCredits() +
                " (GPA = " + String.format("%.2f", countGPA()) + ")" + printL +

//                String.format("%.2f", getPayment().calculatePayment())

                tab + "Bachelor credits: " + degrees.get(0).getCredits()  + printL +
                tab + tab + printCredits(ConstantValues.BACHELOR_TYPE) +
                " (" + degrees.get(0).getCredits() + "/" + ConstantValues.BACHELOR_CREDITS +
                ")" + printL +

                tab + tab + printMandatoryCredits(0) + "/" +
                ConstantValues.BACHELOR_MANDATORY + ")" + printL +

                tab + tab + "GPA of Bachelor studies: " +
                degrees.get(0).getGPA(2).get(2) + printL +


                tab + tab + "Title of BSc Thesis: " + degrees.get(0).getTitleOfThesis() + printL +

                tab + "Master Credits: " + degrees.get(1).getCredits()  + printL +
                tab + tab + printCredits(ConstantValues.MASTER_TYPE) +
                " (" + degrees.get(1).getCredits() + "/" + ConstantValues.MASTER_CREDITS +
                ")" + printL +

                tab + tab + printMandatoryCredits(1) + "/" +
                ConstantValues.MASTER_MANDATORY + ")" + printL +

                tab + tab + "GPA of Bachelor studies: " +
                degrees.get(1).getGPA(2).get(2) + printL +

                tab + tab + "Title of MSc Thesis: " + degrees.get(1).getTitleOfThesis() ;
    }
}

