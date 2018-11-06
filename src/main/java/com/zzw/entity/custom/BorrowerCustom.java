package com.zzw.entity.custom;

import com.zzw.entity.Borrower;
import com.zzw.entity.Loan;

import java.util.List;

public class BorrowerCustom extends Borrower {

    private List<LoanCustom> loanCustoms;

    public List<LoanCustom> getLoanCustoms() {
        return loanCustoms;
    }

    public void setLoanCustoms(List<LoanCustom> loanCustoms) {
        this.loanCustoms = loanCustoms;
    }

    @Override
    public String toString() {
        return super.toString() +
                "BorrowerCustom{" +
                "loanCustoms=" + loanCustoms +
                '}' +
                '\n';
    }
}
