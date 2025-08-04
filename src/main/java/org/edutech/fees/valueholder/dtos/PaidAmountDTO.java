package org.edutech.fees.valueholder.dtos;

import java.sql.Date;

public class PaidAmountDTO {
    private int id;
    private String studentId;
    private double amount;
    private Date paidOn;
    private Date receiptOn;
    private int feeStudentId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(Date paidOn) {
        this.paidOn = paidOn;
    }

    public Date getReceiptOn() {
        return receiptOn;
    }

    public void setReceiptOn(Date receiptOn) {
        this.receiptOn = receiptOn;
    }

    public int getFeeStudentId() {
        return feeStudentId;
    }

    public void setFeeStudentId(int feeStudentId) {
        this.feeStudentId = feeStudentId;
    }
    
}
