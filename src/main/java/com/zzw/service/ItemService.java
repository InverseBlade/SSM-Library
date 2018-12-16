package com.zzw.service;

import com.zzw.entity.Loan;
import com.zzw.entity.custom.BorrowerCustom;
import com.zzw.entity.custom.LoanAffirmInfo;
import com.zzw.entity.custom.LoanCustom;

public interface ItemService {

    int loanItem(String libraryCode, String cardno) throws Exception;

    int returnItem(String libraryCode) throws Exception;

    /**
     * 返回用户及其借阅的所有信息
     *
     * @return BorrowerCustom
     * @throws Exception 异常
     */
    BorrowerCustom findBorrowerWithLoanList(String cardno) throws Exception;

    LoanAffirmInfo getLoanAffirmInfo(String libraryCode) throws Exception;

}
