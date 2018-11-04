package com.zzw.entity.custom;

import java.sql.Timestamp;

public class LoanListVO {

    private Integer loanId;

    private Timestamp loanDate;

    private Integer borrowerId;

    private Integer dueDate;

    private Integer itemId;

    private String libraryCode;

    private String titleName;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Override
    public String toString() {
        return "LoanListVO{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", borrowerId=" + borrowerId +
                ", dueDate=" + dueDate +
                ", itemId=" + itemId +
                ", libraryCode='" + libraryCode + '\'' +
                ", titleName='" + titleName + '\'' +
                '}' +
                "\n";
    }
}
