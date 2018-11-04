package com.zzw.dao;

import com.zzw.entity.Borrower;

public interface BorrowerDao {

    Borrower selectOneById(Integer id);

    Borrower selectOneByCardno(String cardno);

}
