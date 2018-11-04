package com.zzw.dao;

import com.zzw.entity.custom.BorrowerCustom;

import java.util.List;

public interface BorrowerCustomDao {

    BorrowerCustom getBorrowerWithLoansById(Integer id) throws Exception;

}
