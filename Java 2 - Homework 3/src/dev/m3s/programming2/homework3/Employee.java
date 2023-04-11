package dev.m3s.programming2.homework3;

import java.time.Year;

public abstract class Employee extends Person implements Payment {

    //**********    ATTRIBUTES/PARAMETERS
    //***********************************

    private String empId = String.valueOf(getRandomId(ConstantValues.MIN_EMP_ID , ConstantValues.MAX_EMP_ID));
    private int startYear = getCurrentYear();
    Payment payment;



    //**********    CONSTRUCTORS
    //***********************************

    public Employee(String lname,String fname) {
        setLastName(lname);
        setFirstName(fname);

    }

    //**********    METHODS
    //***********************************



    public String getIdString() {
//        String IdString = "Student id: " + this.empId;

        return empId;
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


    public int getCurrentYear() {
        return Year.now().getValue();
    }


    public Payment getPayment() {
        return payment;
    }


    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }


    public double calculatePayment() {
        double paymentAmount = 0.00;

        paymentAmount = payment.calculatePayment();

        return paymentAmount;
    }

    protected abstract String getEmployeeIdString();
//        return Integer.toString(empId); ???


}
