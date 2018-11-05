package com.zzw.service;

import com.zzw.entity.custom.BorrowerCustom;

public interface ItemService {

    int loanItem(String libraryCode, String cardno) throws Exception;

    int returnItem(String libraryCode, String cardno) throws Exception;

    /**
     * 返回用户及其借阅的所有信息
     *
     * @param borrowerId 用户主键
     * @return BorrowerCustom
     * @throws Exception 异常
     */
    BorrowerCustom findBorrowerWithLoanList(String cardno) throws Exception;

}
