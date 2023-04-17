package dev.m3s.programming2.homework3;

public abstract class Person {

    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NO_BIRTHDATE;


    public Person(String lname, String fname) {
        setLastName(lname);
        setFirstName(fname);
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


    public String getBirthDate() {
        return birthDate;
    }


    public String setBirthDate(String personId) {
        if (personId == null) {
            return "No Change";
        }

        PersonID testID = new PersonID();
        String isValid = testID.setPersonId(personId);

        if (isValid.equals("Ok")) {
            String birthdateString = testID.birthdayModifier(personId);
            this.birthDate = birthdateString;

            return birthdateString;
        }
        return "No Change";
    }

    protected int getRandomId(final int min, final int max) {
        int studentId;

        studentId = (int) (Math.random() * ((max - min) + 1)) + min;

        return studentId;
    }


    abstract String getIdString();


}
