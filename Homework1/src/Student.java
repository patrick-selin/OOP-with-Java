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

    // ******* CONSTRACTORS *********
    public Student() {
    }

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // ******* METHODS *********

    //
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
        boolean hasGraduated = this.graduationYear != 0;

        return hasGraduated;
    }

    private boolean canGraduated() {

        return bachelorCredits >= ConstantValues.BACHELOR_CREDITS &&
                masterCredits >= ConstantValues.MASTER_CREDITS &&
                !this.titleOfBachelorThesis.equals(ConstantValues.NO_TITLE) &&
                !this.titleOfMastersThesis.equals(ConstantValues.NO_TITLE);
    }

    public int getStudyYears () {

        // **************
        // tässä on virhe kun kun pitäis tulosaa 0
        // ********************

        if (hasGraduated()) {
            return this.getGraduationYear() - this.getStartYear();
        }
        else {
            return (getCurrentYear() - this.getStartYear());

        }
    }

    public String setPersonId(final int personId) {
        // check if id is correct (use checkPersoinIDNumber)

        return "Ok";
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
                tab + "StartYear: " + startYear + " (studies have lasted for " +
                            getStudyYears() + " years)" + printL +
                tab + "BachelorCredits: " + bachelorCredits + printL +
                tab + "MasterCredits: " + masterCredits + printL +
                tab + "TitleOfMastersThesis: " + titleOfMastersThesis + printL +
                tab + "TitleOfBachelorThesis: " + titleOfBachelorThesis + printL;
    }
}
