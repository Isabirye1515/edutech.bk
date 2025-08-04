package org.edutech.fees.valueholder;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "amount_paid")
public class PaidAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "paid_on")
    private Date paidOn;

    @Column(name = "receipt_on")
    private Date receiptOn;

    @ManyToOne
    @JoinColumn(name = "fees_student_id")
    private FeeStudent feeStudent;

    public PaidAmount() {}

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

    public FeeStudent getFeeStudent() {
        return feeStudent;
    }

    public void setFeeStudent(FeeStudent feeStudent) {
        this.feeStudent = feeStudent;
    }

    

 

    
}
