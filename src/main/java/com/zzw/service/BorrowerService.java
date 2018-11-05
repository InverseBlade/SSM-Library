package com.zzw.service;

import com.zzw.entity.Borrower;

public interface BorrowerService {

    Borrower findBorrowerByCardno(String cardno) throws Exception;

}
