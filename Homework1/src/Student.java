import java.time.Year;

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

    // ******* CONSTRUCTORS *********
    public Student() {
    }

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // ******* METHODS *********

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
        if (canGraduated() &&
            graduationYear >= this.startYear &&
            graduationYear <= getCurrentYear()) {
            this.graduationYear = graduationYear;
            return "Ok";
        }
        else if (!canGraduated()) {
            return "Check the required studies";
        }
        else {
            return "Check graduation year";
        }
    }

    public boolean hasGraduated() {
        return this.graduationYear != 0;
    }

    private boolean canGraduated() {
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

    // ***********************************
    // ************** ID JUTUT************

    

    public String setPersonId(final String personId) {
        // check if id is correct (use checkPersoinIDNumber)

        if (checkPersonIDNumber(personId)) {
            this.birthDate = personId;
            return "Ok";
        }

        return "noooo";
    }





    // ***********************************
    // ***********************************

    private boolean checkPersonIDNumber(final String personId) {
        return personId.length() == 11 &&
                personId.charAt(6) == '-' ||
                personId.charAt(6) == '+' ||
                personId.charAt(6) == 'A';
    }

    private boolean checkLeapYear(int year) {
        boolean isLeapYear;

        isLeapYear = (year % 4 == 0);
        isLeapYear = isLeapYear &&
                     (year % 100 != 0 ||
                      year % 400 == 0);

        return isLeapYear;
    }

    // tämä ei sinällään vielä toimi, ehkä tehdä dictionary tästä,
    // mutta katso ensin mitä testit sanoo kun palautat tehtävän
    private boolean checkValidCharacter(final String personID) {
        String validChars = "0123456789ABCDEFHJKLMNPRSTUVWXY";
        String numbersStr = personID.substring(0,6) + personID.substring(7,10);

        int number = Integer.parseInt(numbersStr);
        int ControlChar= number % 31;

        return (validChars.charAt(ControlChar) == personID.charAt(10));
    }

    public boolean checkBirthdate(final String date) {
        boolean isValidDate = true;

        String dayStr = date.substring(0,2);
        int dayNum = Integer.parseInt(dayStr);
        System.out.println(dayNum);

        String monthStr = date.substring(2,4);
        int monthNum = Integer.parseInt(monthStr);
        System.out.println(monthNum);

        String yearStr = date.substring(4,6);
        int yearNum = Integer.parseInt(yearStr);
        System.out.println(yearNum);

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

    @Override
    public String toString() {

        String tab = "\t";
        String printL = "\n";

        return "Student id: " + id + printL +
                tab + "FirstName: " + firstName + ", " +
                       "LastName: " + lastName + printL +
                tab + "Status: " + statusPrinter() + printL +
                tab + "Date of birth: " + this.birthDate + printL; // +
                // tab + "StartYear: " + startYear + " (studies have lasted for " +
                //            getStudyYears() + " years)" + printL +
                // tab + "BachelorCredits: " + bachelorCredits + printL +
                // tab + "MasterCredits: " + masterCredits + printL +
                // tab + "TitleOfMastersThesis: " + titleOfMastersThesis + printL +
                // tab + "TitleOfBachelorThesis: " + titleOfBachelorThesis + printL;
    }
}
