package com.zzw.service.impl;

import com.zzw.dao.*;
import com.zzw.entity.Borrower;
import com.zzw.entity.Item;
import com.zzw.entity.Loan;
import com.zzw.entity.Title;
import com.zzw.entity.custom.*;
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

    private TitleDao titleDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao,
                           LoanDao loanDao,
                           BorrowerDao borrowerDao,
                           BorrowerCustomDao borrowerCustomDao,
                           TitleDao titleDao) {
        this.itemDao = itemDao;
        this.loanDao = loanDao;
        this.borrowerDao = borrowerDao;
        this.borrowerCustomDao = borrowerCustomDao;
        this.titleDao = titleDao;
    }

    @Override
    public LoanAffirmInfo getLoanAffirmInfo(String libraryCode) throws Exception {
        Item item = itemDao.selectOneByLibraryCode(libraryCode);
        if (item == null) {
            throw new Exception("书目编号不存在");
        }
        Loan loan = loanDao.selectOneById(item.getmLoan());
        if (loan == null) {
            throw new Exception("该物品未被借阅");
        }
        Borrower borrower = borrowerDao.selectOneById(loan.getBorrowerId());
        Title title = titleDao.selectOneById(item.getTitleId());

        LoanAffirmInfo loanAffirmInfo = new LoanAffirmInfo();
        loanAffirmInfo.setLoan(loan);
        loanAffirmInfo.setCardno(borrower.getCardno());
        loanAffirmInfo.setLibraryCode(item.getLibraryCode());
        loanAffirmInfo.setTitleName(title.getName());

        return loanAffirmInfo;
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
    public int returnItem(String libraryCode) throws Exception {
        //
        Item item = itemDao.selectOneByLibraryCode(libraryCode);
        if (null == item) {
            throw new Exception("项目编号不存在!");
        }
        if (null == item.getmLoan()) {
            throw new Exception("该物品还未被借阅!");
        }
        Loan loan = loanDao.selectOneById(item.getmLoan());
        if (loan == null) {
            throw new Exception("数据库数据异常出错!");
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
