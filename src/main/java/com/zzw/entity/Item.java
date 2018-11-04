package com.zzw.entity;

public class Item {

    private Integer id;

    private String libraryCode;

    private Integer mLoan;

    private Integer mLoseBook;

    private Integer mReservation;

    private Integer titleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }

    public Integer getmLoan() {
        return mLoan;
    }

    public void setmLoan(Integer mLoan) {
        this.mLoan = mLoan;
    }

    public Integer getmLoseBook() {
        return mLoseBook;
    }

    public void setmLoseBook(Integer mLoseBook) {
        this.mLoseBook = mLoseBook;
    }

    public Integer getmReservation() {
        return mReservation;
    }

    public void setmReservation(Integer mReservation) {
        this.mReservation = mReservation;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", libraryCode='" + libraryCode + '\'' +
                ", mLoan=" + mLoan +
                ", mLoseBook=" + mLoseBook +
                ", mReservation=" + mReservation +
                ", titleId=" + titleId +
                '}' +
                '\n';
    }
}
