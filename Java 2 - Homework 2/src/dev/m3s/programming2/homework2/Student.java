package dev.m3s.programming2.homework2;

import java.time.Year;
import java.util.Arrays;

public class Student {
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id = getRandomId();
//    private double bachelorCredits = 0;
//    private double masterCredits = 0;
//    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
//    private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
    private int startYear = getCurrentYear();
    private int graduationYear;
    private int degreeCount = 3;
    private Degree[] degrees = new Degree[3];

    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public Student() {
        degrees[0] = new Degree();
        degrees[1] = new Degree();
        degrees[2] = new Degree();
    }

    public Student(String lastName, String firstName) {
        this();
        setLastName(lastName);
        setFirstName(firstName);
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if (firstName != null &&
            !firstName.equals("")) {
            this.firstName = firstName;
        }
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        if (lastName != null &&
                !lastName.equals("")) {
            this.lastName = lastName;
        }
    }

    private int getRandomId() {
        int min = ConstantValues.MIN_ID;
        int max = ConstantValues.MAX_ID;
        int studentId;

        studentId = (int) (Math.random() * ((max - min) + 1)) + min;

        return studentId;
    }


    public int getId() {
        return id;
    }


    public void setId(final int id) {
        int min = ConstantValues.MIN_ID;
        int max = ConstantValues.MAX_ID;
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

        if (dName != null && i >= 0 && i < degreeCount) {
            degrees[i].setDegreeTitle(dName);
        }
    }




    public boolean addCourse(final int i, StudentCourse course) {
        boolean onko = false;

        if (course != null && i >= 0 && i < degreeCount) {
            Degree setDegCourse = new Degree();
            setDegCourse.addStudentCourse(course);

            onko = true;
        }
        return onko;
    }

    public int addCourses(final int i, StudentCourse[] courses) {


        int numAddedCourses = 0;

        if (courses != null && i >= 0 && i < degreeCount) {

        Degree dgr99 = new Degree();



        degrees[0] = dgr99;

//            Degree setDegCourses = new Degree();
//            setDegCourses.addStudentCourses(courses);
//
//            for (StudentCourse x: courses) {
//                if ( x != null ) {
//                    numAddedCourses++;
//                }
//            }
        }
        return numAddedCourses;
    }

    public void tuloste() {
//        System.out.println("puu");
//
//        for (Degree dgr : degrees) {
//            System.out.println(dgr);
//        }
//        degrees[0].getDegreeTitle();
    }



    // +++++++++++++++++++++++++++++++++++++++++++++++++++++
    // +++++++++++  TÄHÄN ASTI VALMIS, ei testattu
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++

// näistä paljon poistuu/vaihtuu alla


//    public double getBachelorCredits() {
//        return bachelorCredits;
//    }
//
//
//    public void setBachelorCredits(final double bachelorCredits) {
//        if (bachelorCredits >= ConstantValues.MIN_CREDITS &&
//                bachelorCredits <= ConstantValues.MAX_CREDITS) {
//            this.bachelorCredits = bachelorCredits;
//        }
//    }
//
//
//    public double getMasterCredits() {
//        return masterCredits;
//    }
//
//
//    public void setMasterCredits(final double masterCredits) {
//        if (masterCredits >= ConstantValues.MIN_CREDITS &&
//                masterCredits <= ConstantValues.MAX_CREDITS) {
//            this.masterCredits = masterCredits;
//        }
//    }



    public void setTitleOfThesis(int i, String title) {
        if (title != null && i >= 0 && i < degreeCount) {
            degrees[i].setTitleOfThesis(title);
        }
    }






//    public int getGraduationYear() {
//        return graduationYear;
//    }
//
//
//    public String setGraduationYear(final int graduationYear) {
//        if (canGraduate() &&
//                graduationYear >= this.startYear &&
//                graduationYear <= getCurrentYear()) {
//            this.graduationYear = graduationYear;
//            return "Ok";
//        }
//        else if (!canGraduate()) {
//            return "Check amount of required credits";
//        }
//        else {
//            return "Check graduation year";
//        }
//    }




    public void printCourses() {


    }


    public boolean hasGraduated() {
        return this.graduationYear != 0;
    }


    // vaihda PRIVATEKSI
    public boolean canGraduate() {
        boolean canGraduate = false;

        // if enough required credits, bachelor and masters AND
        // both title are set, bachelor and master




//        bachelorCredits >= ConstantValues.BACHELOR_CREDITS &&
//                masterCredits >= ConstantValues.MASTER_CREDITS &&
//                !this.titleOfBachelorThesis.equals(ConstantValues.NO_TITLE) &&
//                !this.titleOfMastersThesis.equals(ConstantValues.NO_TITLE);

        return canGraduate;

    }



//    public int getStudyYears () {
//        if (hasGraduated()) {
//            return this.getGraduationYear() - this.getStartYear();
//        }
//        else {
//            return (getCurrentYear() - this.getStartYear());
//        }
//    }


    // täältä otettiin pois ID-jutut --> PersonID-luokkaan


    private String statusPrinter() {
        if (hasGraduated()) {
            return "The student has graduated in " + graduationYear;
        }
        else {
            return "The student has not graduated, yet.";
        }
    }

//    private double missingBachelorCredits() {
//        return ConstantValues.BACHELOR_CREDITS - bachelorCredits;
//    }
//
//    private double missingMasterCredits() {
//        return ConstantValues.MASTER_CREDITS - masterCredits;
//    }

//    private String bachelorCreditsPrinter() {
//        if (getBachelorCredits() >= ConstantValues.BACHELOR_CREDITS) {
//            return "All required bachelor credits completed (" +
//                    bachelorCredits + "/" + ConstantValues.BACHELOR_CREDITS + ")";
//        }
//        else {
//            return "Missing bachelor credits " + missingBachelorCredits() +
//                    " (" + bachelorCredits + "/"
//                    + ConstantValues.BACHELOR_CREDITS + ")";
//        }
//    }
//
//    private String masterCreditsPrinter() {
//        if (getMasterCredits() >= ConstantValues.MASTER_CREDITS) {
//            return "All required master's credits completed (" +
//                    masterCredits + "/" + ConstantValues.MASTER_CREDITS + ")";
//        }
//        else {
//
//            return "Missing master's credits " + missingMasterCredits() +
//                    " (" + masterCredits + "/"
//                    + ConstantValues.MASTER_CREDITS + ")";
//
//        }
//    }


    public double testiCreditsGetter() {
        double kreditit = 0.00;

        Degree testDegree = new Degree();

        kreditit = testDegree.getCredits();

        return kreditit;
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
//                tab + "StartYear: " + startYear + " (studies have lasted for " +
//                dgetStudyYears() + " years)" + printL +
//
//                tab + "Total credits testi: " + testiCreditsGetter() + printL +
//
//                tab + "Total credits: " + "PUUTTUU VIELÄ METHOD .getCredits() " + printL +
//                tab + "Bachelor credits: " + "PUUTTUU VIELÄ" + printL +
//                tab + tab + "Total bachelor credits completed " + printL ;


//                tab + "BachelorCredits: " + bachelorCredits + " ==> "
//                + bachelorCreditsPrinter() + printL +
//                tab + "TitleOfBachelorThesis: " + titleOfBachelorThesis + printL +
//                tab + "MasterCredits: " + masterCredits  + " ==> "
//                + masterCreditsPrinter() + printL +
//                tab + "TitleOfMastersThesis: " + titleOfMastersThesis + printL;
//    }
}
