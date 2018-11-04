package com.zzw.dao;

import com.mchange.util.AssertException;
import com.zzw.BaseTest;
import com.zzw.entity.Loan;
import com.zzw.entity.custom.LoanCustom;
import com.zzw.entity.custom.LoanListVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class LoanDaoTest extends BaseTest {

    @Autowired
    private LoanDao loanDao;

    @Test
    public void testSelectListByBorrowerId() {
        int page, offset, limit = 2;

        page = 2;
        offset = page * limit;

        List<Loan> loans = loanDao.selectListByBorrowerId(1, offset, limit);
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    @Test
    public void testSelectBorrowingByBorrowerId() {
        List<LoanListVO> list = loanDao.selectBorrowingByBorrowerId(1);
        for (LoanListVO loan : list) {
            System.out.println(loan);
        }
    }

    @Test
    public void testSelectOneById() {
        System.out.println(loanDao.selectOneById(2));
    }

    @Test
    public void testInsertOneAndGetId() {
        Loan loan = new Loan();
        loan.setDueDate(0);
        loan.setLoanDate(new Timestamp(new Date().getTime()));
        loan.setBorrowerId(1);
        loan.setItemId(1);
        loanDao.insertOneAndGetId(loan);

        int id = loan.getId();
        if (id == 0) {
            throw new AssertException("Insert Failed!");
        } else {
            System.out.println(id);
        }
    }

}
