//package dev.m3s.programming2.homework1;

import java.time.Year;
import java.util.HashMap;

public class Student {
    private String lastName = ConstantValues.NO_NAME;
    private String firstName = ConstantValues.NO_NAME;
    private int id = getRandomId();
    private double bachelorCredits = 0;
    private double masterCredits = 0;
    private String titleOfMastersThesis = ConstantValues.NO_TITLE;
    private String titleOfBachelorThesis = ConstantValues.NO_TITLE;
    private int startYear = getCurrentYear();
    private int graduationYear;
    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public Student() {
    }

    public Student(String lastName, String firstName) {
        setLastName(lastName);
        setFirstName(firstName);
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }


    public String getLastName() {

        return lastName;
    }


    public void setLastName(String lastName) {
        if (lastName != null) {
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


    public double getBachelorCredits() {
        return bachelorCredits;
    }


    public void setBachelorCredits(final double bachelorCredits) {
        if (bachelorCredits >= ConstantValues.MIN_CREDIT &&
                bachelorCredits <= ConstantValues.MAX_CREDITS) {
            this.bachelorCredits = bachelorCredits;
        }
    }


    public double getMasterCredits() {
        return masterCredits;
    }


    public void setMasterCredits(final double masterCredits) {
        if (masterCredits >= ConstantValues.MIN_CREDIT &&
                masterCredits <= ConstantValues.MAX_CREDITS) {
            this.masterCredits = masterCredits;
        }
    }


    public String getTitleOfMastersThesis() {
        return titleOfMastersThesis;
    }


    public void setTitleOfMastersThesis(String title) {
        if (title != null) {
            this.titleOfMastersThesis = title;
        }
    }


    public String getTitleOfBachelorThesis() {
        return titleOfBachelorThesis;
    }


    public void setTitleOfBachelorThesis(String title) {
        if (title != null) {
            this.titleOfBachelorThesis = title;
        }
    }

    public int getCurrentYear() {
        return Year.now().getValue();
    }


    public int getStartYear() {
        return startYear;
    }


    public void setStartYear(final int startYear) {
        int min = ConstantValues.MIN_START_YEAR;
        int max = getCurrentYear();

        if (startYear > min &&
                startYear <= max) {
            this.startYear = startYear;
        }
    }

    public int getGraduationYear() {
        return graduationYear;
    }


    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() &&
            graduationYear >= this.startYear &&
            graduationYear <= getCurrentYear()) {
            this.graduationYear = graduationYear;
            return "Ok";
        }
        else if (!canGraduate()) {
            return "Check the required studies";
        }
        else {
            return "Check graduation year";
        }
    }

    public boolean hasGraduated() {
        return this.graduationYear != 0;
    }


    private boolean canGraduate() {
        return bachelorCredits >= ConstantValues.BACHELOR_CREDITS &&
                masterCredits >= ConstantValues.MASTER_CREDITS &&
                !this.titleOfBachelorThesis.equals(ConstantValues.NO_TITLE) &&
                !this.titleOfMastersThesis.equals(ConstantValues.NO_TITLE);
    }


    public int getStudyYears () {
        if (hasGraduated()) {
            return this.getGraduationYear() - this.getStartYear();
        }
        else {
            return (getCurrentYear() - this.getStartYear());
        }
    }


    public String setPersonId(final String personId) {
        if (!checkPersonIDNumber(personId)) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        String bdayFormatted = birthdayModifier(personId);

        if (!checkBirthdate(bdayFormatted )) {
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if (!checkValidCharacter(personId)) {
            return ConstantValues.INCORRECT_CHECKMARK;
        }

        this.birthDate = birthdayModifier(personId);

        return "Ok";
    }


    private String birthdayModifier(final String personId) {

        String bdayModified;

        String dayStr = personId.substring(0,2);
        String monthStr = personId.substring(2,4);
        String yearStr = personId.substring(4,6);

        String century = "";

        if (personId.charAt(6) == '+') {
            century = "18";
        } else if (personId.charAt(6) == 'A') {
            century = "20";
        } else if (personId.charAt(6) == '-') {
            century = "19";
        }

        bdayModified = dayStr + "." + monthStr
                        + "." + century + yearStr;

        return bdayModified;
    }


    private boolean checkPersonIDNumber(final String personId) {
        return personId.length() == 11&& (
                personId.charAt(6) == '-' ||
                personId.charAt(6) == '+' ||
                personId.charAt(6) == 'A');
    }


    private boolean checkLeapYear(int year) {
        boolean isLeapYear;

        isLeapYear = (year % 4 == 0);
        isLeapYear = isLeapYear &&
                     (year % 100 != 0 ||
                      year % 400 == 0);

        return isLeapYear;
    }


    private boolean checkValidCharacter(final String personID) {
        boolean isValidChar = false;

        String firstNumStr = personID.substring(0,6);
        String secondNumStr = personID.substring(7,10);

        String wholeNumberStr = firstNumStr +secondNumStr;
        double wholeNumber = Integer.parseInt(wholeNumberStr);

        double sum = ((wholeNumber / 31) % 1) * 31;
        int sum4 = (int) Math.round(sum);

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("A", (10)); hm.put("B", (11)); hm.put("C", (12));
        hm.put("D", (13)); hm.put("E", (14)); hm.put("F", (15));
        hm.put("H", (16)); hm.put("J", (17)); hm.put("K", (18));
        hm.put("L", (19)); hm.put("M", (20)); hm.put("N", (21));
        hm.put("P", (22)); hm.put("R", (23)); hm.put("S", (24));
        hm.put("T", (25)); hm.put("U", (26)); hm.put("V", (27));
        hm.put("W", (28)); hm.put("X", (29)); hm.put("Y", (30));

        hm.put("0", (0)); hm.put("1", (1)); hm.put("2", (2));
        hm.put("3", (3)); hm.put("4", (4)); hm.put("5", (5));
        hm.put("6", (6)); hm.put("7", (7)); hm.put("8", (8));
        hm.put("9", (9));

        String lastChar = personID.substring(10,11); // R

        if (hm.containsKey(lastChar)) {
            int value = hm.get(lastChar);

            if (value== sum4) {
                isValidChar = true;
            }
        }

        return isValidChar;
    }


    private boolean checkBirthdate(final String date) {
        // 11.12.1222

        boolean isValidDate = true;

        String dayStr = date.substring(0,2);
        int dayNum = Integer.parseInt(dayStr);

        String monthStr = date.substring(3,5);
        int monthNum = Integer.parseInt(monthStr);

        String yearStr = date.substring(6,10);
        int yearNum = Integer.parseInt(yearStr);

        if (yearNum < 0 || monthNum < 1 || monthNum > 12 ||
            dayNum < 1 || dayNum > 31) {
            isValidDate = false;
        }
        else {
            switch (monthNum) {
                case 4, 6, 9, 11 -> {
                    if (dayNum == 31)
                        isValidDate = false;
                }
                case 2 -> {
                    if (dayNum > 29)
                        isValidDate = false;
                    if (dayNum == 29)
                        isValidDate = checkLeapYear(yearNum);
                }
            }
        }
        return isValidDate;
    }

    private String statusPrinter() {
        if (hasGraduated()) {
            return "The student has graduated in " + graduationYear;
        }
        else {
            return "The student has not graduated, yet.";
        }
    }

    private double missingBachelorCredits() {
        return ConstantValues.BACHELOR_CREDITS - bachelorCredits;
    }

    private double missingMasterCredits() {
        return ConstantValues.MASTER_CREDITS - masterCredits;
    }

    private String bachelorCreditsPrinter() {
        if (getBachelorCredits() >= ConstantValues.BACHELOR_CREDITS) {
            return "All required bachelor credits completed (" +
                    bachelorCredits + "/" + ConstantValues.BACHELOR_CREDITS + ")";
        }
        else {
            return "Missing bachelor credits " + missingBachelorCredits() +
                    " (" + bachelorCredits + "/"
                    + ConstantValues.BACHELOR_CREDITS + ")";
        }
    }

    private String masterCreditsPrinter() {
        if (getMasterCredits() >= ConstantValues.MASTER_CREDITS) {
            return "All required master's credits completed (" +
                    masterCredits + "/" + ConstantValues.MASTER_CREDITS + ")";
        }
        else {
            return "Missing master's credits " + missingMasterCredits() +
                    " (" + masterCredits + "/"
                    + ConstantValues.MASTER_CREDITS + ")";
        }
    }


    @Override
    public String toString() {
        String tab = "\t";
        String printL = "\n";

        return "Student id: " + id + printL +
                tab + "FirstName: " + firstName + ", " +
                       "LastName: " + lastName + printL +
                tab + "Date of birth: " + birthDate + printL +
                tab + "Status: " + statusPrinter() + printL +
                tab + "StartYear: " + startYear + " (studies have lasted for " +
                            getStudyYears() + " years)" + printL +
                tab + "BachelorCredits: " + bachelorCredits + " ==> "
                + bachelorCreditsPrinter() + printL +
                tab + "TitleOfBachelorThesis: " + titleOfBachelorThesis + printL +
                tab + "MasterCredits: " + masterCredits  + " ==> "
                + masterCreditsPrinter() + printL +
                tab + "TitleOfMastersThesis: " + titleOfMastersThesis + printL;
    }
}
