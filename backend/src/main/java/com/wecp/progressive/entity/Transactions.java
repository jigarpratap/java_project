package com.wecp.progressive.entity;
import java.util.Date;
 
 
public class Transactions {
    private int transactionId;
    private int accountId;
    private double amount;
    private String transaction_type;
    private Date transaction_date;
 
   
    public Transactions() {
    }
   
    public Transactions(int transactionId, int accountId, double amount, Date transaction_date,
            String transaction_type) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.transaction_date = transaction_date;
        this.transaction_type = transaction_type;
    }
   
    public int getTransactionId() {
        return transactionId;
    }
 
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
 
    public int getAccountId() {
        return accountId;
    }
 
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
 
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getTransaction_date() {
        return transaction_date;
    }
    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }
    public String getTransaction_type() {
        return transaction_type;
    }
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
 
 
}
