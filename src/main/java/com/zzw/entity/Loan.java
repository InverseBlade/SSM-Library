package com.zzw.entity;

import java.sql.Timestamp;

public class Loan {

    private Integer id;

    private Timestamp loanDate;

    private Integer borrowerId;

    private Integer dueDate;

    private Integer itemId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Timestamp loanDate) {
        this.loanDate = loanDate;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Integer getDueDate() {
        return dueDate;
    }

    public void setDueDate(Integer dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", borrowerId=" + borrowerId +
                ", dueDate=" + dueDate +
                '}' +
                '\n';
    }
}
