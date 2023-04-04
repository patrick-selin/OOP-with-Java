package dev.m3s.programming2.homework3;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Student extends Person {
//    private String firstName = ConstantValues.NO_NAME;
//    private String lastName = ConstantValues.NO_NAME;
    private int id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
    private int startYear = getCurrentYear();
    private int graduationYear;
//    private int degreeCount = 3;
//    private Degree[] degrees = new Degree[3];
    ArrayList<Degree> degrees = new ArrayList<>();

//    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public Student() {
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
//        degrees[0] = new Degree();
//        degrees[1] = new Degree();
//        degrees[2] = new Degree();
    }
//
//
    public Student(String lastName, String firstName) {
        this();
        setLastName(lastName);
        setFirstName(firstName);
        // muistaa set ID person-inheritance????
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
                i <= degrees.size() ) {

            degrees.get(i).addStudentCourse(course);
            onko = true;
        }

        return onko;
    }


    public int addCourses(final int i, ArrayList<StudentCourse> courses) {
        int numAddedCourses = 0;

        if (courses != null && i >= 0 && i < degrees.size()) {


            for (StudentCourse x: courses) {
                if ( x != null && degrees.get(i).addStudentCourse(x)) {
                    numAddedCourses++;
                }
            }
        }
        return numAddedCourses;
    }


//    public void printDegrees() {
//        for (Degree dd : degrees) {
//            System.out.println(dd.toString());
//        }
//
//    }


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












//    public int getStudyYears() {
//        if (hasGraduated()) {
//            return getGraduationYear() - this.startYear;
//        }
//
//        return getCurrentYear() - this.startYear;
//    }
//
//
//    private String statusPrinter() {
//        if (hasGraduated()) {
//            return "The student has graduated in " + graduationYear;
//        }
//        else {
//            return "The student has not graduated, yet.";
//        }
//    }
//
//
//    public double getAllCredits() {
//        return degrees[0].getCredits() + degrees[1].getCredits();
//    }
//
//
//    public String printCredits(int degree) {
//        if (degree == ConstantValues.BACHELOR_TYPE) {
//            if ( degrees[ConstantValues.BACHELOR_TYPE].getCredits()
//                    >= ConstantValues.BACHELOR_CREDITS) {
//                return "Total bachelor credits completed";
//            }
//            else return "Missing bachelor's credits " +
//                    (ConstantValues.BACHELOR_CREDITS -
//                            degrees[ConstantValues.BACHELOR_TYPE].getCredits());
//        }
//        if ( degrees[ConstantValues.MASTER_TYPE].getCredits() >= ConstantValues.MASTER_CREDITS) {
//            return "Total master's credits completed";
//        }
//        else return "Missing master's credits  " +
//                (ConstantValues.MASTER_CREDITS - degrees[ConstantValues.MASTER_TYPE].getCredits());
//    }

    public String getIdString() {
//        String temppi = "Student TEMPPI id: 42";
        // returm a sting of a user id "Student id: 42"

        String IdString = "Student id: " + this.id;

        return IdString;
    }


//    @Override
//    public String toString() {
//        String tab = "\t";
//        String printL = "\n";
//
//        return "Student id: " + id + printL +
//                tab + "FirstName: " + firstName + ", " +
//                "LastName: " + lastName + printL +
//                tab + "Date of birth: " + birthDate + printL +
//                tab + "Status: " + statusPrinter() + printL +
//                tab + "Start year: " + startYear + " (studies have lasted for " +
//                getStudyYears() + " years)" + printL +
//
//                tab + "Total credits: " + getAllCredits() +
//                " (GPA = " + "99,9" + ")" + printL +
//
//                tab + "Bachelor credits: " + degrees[0].getCredits()  + printL +
//                tab + tab + printCredits(ConstantValues.BACHELOR_TYPE) +
//                " (" + degrees[0].getCredits() + "/" + ConstantValues.BACHELOR_CREDITS +
//                ")" + printL +
//
//                tab + tab + "Title of BSc Thesis: " + degrees[0].getTitleOfThesis() + printL +
//
//                tab + "Master Credits: " + degrees[1].getCredits()  + printL +
//                tab + tab + printCredits(ConstantValues.MASTER_TYPE) +
//                " (" + degrees[1].getCredits() + "/" + ConstantValues.MASTER_CREDITS +
//                ")" + printL +
//
//                tab + tab + "Title of MSc Thesis: " + degrees[1].getTitleOfThesis() ;
//    }
}

// ************************************************************
// ****     poistetut  **********************

//    public String getFirstName() {
//        return firstName;
//    }
//
//
//    public void setFirstName(String firstName) {
//        if (firstName != null &&
//                !firstName.equals("")) {
//            this.firstName = firstName;
//        }
//    }
//
//
//    public String getLastName() {
//        return lastName;
//    }
//
//
//    public void setLastName(String lastName) {
//        if (lastName != null &&
//                !lastName.equals("")) {
//            this.lastName = lastName;
//        }
//    }


//    private int getRandomId() {
//        int min = ConstantValues.MIN_ID;
//        int max = ConstantValues.MAX_ID;
//        int studentId;
//
//        studentId = (int) (Math.random() * ((max - min) + 1)) + min;
//
//        return studentId;
//    }

