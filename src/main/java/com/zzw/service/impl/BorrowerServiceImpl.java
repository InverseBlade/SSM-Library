package com.zzw.service.impl;

import com.zzw.dao.BorrowerDao;
import com.zzw.entity.Borrower;
import com.zzw.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    private BorrowerDao borrowerDao;

    @Autowired
    public BorrowerServiceImpl(BorrowerDao borrowerDao) {
        this.borrowerDao = borrowerDao;
    }

    @Override
    public Borrower findBorrowerByCardno(String cardno) throws Exception {
        Borrower borrower = borrowerDao.selectOneByCardno(cardno);
        if (borrower == null) {
            throw new Exception("借阅号无效!");
        }
        return borrower;
    }

    @Override
    public Borrower findBorrowerById(Integer id) throws Exception {
        return borrowerDao.selectOneById(id);
    }
}
