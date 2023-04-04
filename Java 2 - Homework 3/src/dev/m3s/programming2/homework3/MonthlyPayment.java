package dev.m3s.programming2.homework3;

public class MonthlyPayment {

    //**********    ATTRIBUTES/PARAMETERS
    //***********************************

    private double salary = 1.11;



    //**********    METHODS
    //***********************************


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    double calculatePayment() {
        return salary;
    }


}
