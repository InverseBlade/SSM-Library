package com.zzw.dao;

import com.zzw.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowerCustomDaoTest extends BaseTest {

    @Autowired
    private BorrowerCustomDao borrowerCustomDao;

    @Test
    public void testGetBorrowerWithLoansById() throws Exception {
        System.out.println(borrowerCustomDao.getBorrowerWithLoansById(1));
    }

}
