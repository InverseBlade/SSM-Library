package com.zzw.dao;

import com.mchange.util.AssertException;
import com.zzw.BaseTest;
import com.zzw.entity.Borrower;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowerDaoTest extends BaseTest {

    @Autowired
    private BorrowerDao borrowerDao;

    @Test
    public void testSelectOneById() throws Exception {
        Borrower borrower = borrowerDao.selectOneById(1);
        if (null == borrower) {
            System.out.println("Not Found!");
        } else {
            System.out.println(borrower);
        }
    }

    @Test
    public void testSelectOneByCardno() throws Exception {
        Borrower borrower = borrowerDao.selectOneByCardno("25924");
        if (null == borrower) {
            System.out.println("Not Found!");
            //throw new AssertException();
        } else {
            System.out.println(borrower);
        }
    }

}
