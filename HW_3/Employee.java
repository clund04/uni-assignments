package dev.m3s.programming2.homework3;

import java.time.Year;

public abstract class Employee extends Person implements Payment {
    
    private String empId = getEmployeeIdString() +
            String.valueOf(super.getRandomId(ConstantValues.MIN_EMP_ID , ConstantValues.MAX_EMP_ID));
    private int startYear = getCurrentYear();
    private Payment payment;

    public Employee(String lname, String fname) {
        super(lname, fname);
    }

    private int getCurrentYear() {
        return Year.now().getValue();
    }
    

    public String getIdString() {
        return empId;
    }

    public int getStartYear() {
        return getCurrentYear();
    }

    public void setStartYear(final int startYear) {
        if (2000 < startYear &&
            startYear <= getCurrentYear()) {
                this.startYear = startYear;
        }
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
        if (payment != null) {
            return payment.calculatePayment();
        } else {
            return 0.0;
        }
    }

    protected abstract String getEmployeeIdString();

}
