package com.zzw.service.impl;

import com.zzw.dao.BorrowerCustomDao;
import com.zzw.dao.BorrowerDao;
import com.zzw.dao.ItemDao;
import com.zzw.dao.LoanDao;
import com.zzw.entity.Borrower;
import com.zzw.entity.Item;
import com.zzw.entity.Loan;
import com.zzw.entity.custom.BorrowerCustom;
import com.zzw.entity.custom.LoanListVO;
import com.zzw.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    private LoanDao loanDao;

    private BorrowerDao borrowerDao;

    private BorrowerCustomDao borrowerCustomDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao, LoanDao loanDao, BorrowerDao borrowerDao, BorrowerCustomDao borrowerCustomDao) {
        this.itemDao = itemDao;
        this.loanDao = loanDao;
        this.borrowerDao = borrowerDao;
        this.borrowerCustomDao = borrowerCustomDao;
    }

    @Override
    public int loanItem(String libraryCode, String cardno) throws Exception {
        //
        Borrower borrower = borrowerDao.selectOneByCardno(cardno);
        if (null == borrower) {
            throw new Exception("借阅证号无效!");
        }
        Item item = itemDao.selectOneByLibraryCode(libraryCode);
        if (null == item) {
            throw new Exception("项目编号不存在!");
        }
        if (null != item.getmLoan()) {
            throw new Exception("该物品已经被借阅!");
        }
        //TO-DO


        Loan loan = new Loan();
        loan.setItemId(item.getId());
        loan.setBorrowerId(borrower.getId());
        loan.setLoanDate(new Timestamp(System.currentTimeMillis()));
        loan.setDueDate(0);

        loanDao.insertOneAndGetId(loan);
        itemDao.updateOneLoanInfoById(item.getId(), loan.getId());

        return 0;
    }

    @Override
    public int returnItem(String libraryCode, String cardno) throws Exception {
        //
        Borrower borrower = borrowerDao.selectOneByCardno(cardno);
        if (null == borrower) {
            throw new Exception("借阅证号无效!");
        }
        Item item = itemDao.selectOneByLibraryCode(libraryCode);
        if (null == item) {
            throw new Exception("项目编号不存在!");
        }
        if (null == item.getmLoan()) {
            throw new Exception("该物品还未被借阅!");
        }
        Loan loan = loanDao.selectOneByBorrowerAndItem(borrower.getId(), item.getId());
        if (loan == null) {
            throw new Exception("该借阅者没有借阅此书的记录!");
        }
        //TO-DO

        itemDao.updateOneLoanInfoById(item.getId(), null);

        return 0;
    }

    @Override
    public BorrowerCustom findBorrowerWithLoanList(String cardno) throws Exception {
        Borrower borrower = borrowerDao.selectOneByCardno(cardno);
        if (null == borrower) {
            throw new Exception("借阅卡号无效!");
        }
        return borrowerCustomDao.getBorrowerWithLoansById(borrower.getId());
    }
}
