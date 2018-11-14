package com.zzw.service;

import com.zzw.BaseTest;
import com.zzw.entity.Borrower;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowerServiceTest extends BaseTest {

    @Autowired
    private BorrowerService borrowerService;

    @Test
    public void testFindBorrowerByCardno() {
        try {
            Borrower borrower = borrowerService.findBorrowerByCardno("259725");
            if (null == borrower) {
                System.out.println("未找到!");
                return;
            }
            System.out.println(borrower);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
