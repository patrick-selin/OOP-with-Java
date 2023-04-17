package dev.m3s.programming2.homework3;

import java.time.Year;

public abstract class Employee extends Person implements Payment {

    private String empId = String.valueOf(getRandomId(ConstantValues.MIN_EMP_ID , ConstantValues.MAX_EMP_ID));
    private int startYear = getCurrentYear();
    private Payment payment;


    public Employee(String lname,String fname) {
        super(lname, fname);
    }


    public String getIdString() {
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

}
