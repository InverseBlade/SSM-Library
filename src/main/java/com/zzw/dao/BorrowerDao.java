package com.zzw.dao;

import com.zzw.entity.Borrower;

public interface BorrowerDao {

    Borrower selectOneById(Integer id) throws Exception;

    Borrower selectOneByCardno(String cardno) throws Exception;

}
