package com.zzw.entity.custom;

import com.zzw.entity.Borrower;
import com.zzw.entity.Item;
import com.zzw.entity.Loan;

public class LoanCustom extends Loan {

    // borrower = null, 暂时先不用
    private Borrower borrower;

    private ItemCustom itemCustom;

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public ItemCustom getItemCustom() {
        return itemCustom;
    }

    public void setItemCustom(ItemCustom itemCustom) {
        this.itemCustom = itemCustom;
    }

    @Override
    public String toString() {
        return super.toString() +
                "LoanCustom{" +
                "borrower=" + borrower +
                ", itemCustom=" + itemCustom +
                '}' +
                '\n';
    }
}
