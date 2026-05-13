package com.edutrack.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment_records")
public class PaymentRecord {
    @Id
    private String id;
    private String studentId;
    private double amount;
    private String date;
    private String receiptBase64;

    public PaymentRecord() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getReceiptBase64() { return receiptBase64; }
    public void setReceiptBase64(String receiptBase64) { this.receiptBase64 = receiptBase64; }
}
