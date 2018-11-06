package com.zzw.service;

import com.zzw.BaseTest;
import com.zzw.entity.Borrower;
import com.zzw.entity.custom.BorrowerCustom;
import com.zzw.entity.custom.LoanCustom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceTest extends BaseTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void testReturnItem() {
        try {
            String cardno = "259724";
            String libraryCode = "LIB0001";
            int code;

            code = itemService.returnItem(libraryCode, cardno);
            if (code != 0) {
                throw new Exception("未知错误");
            }
            System.out.println("还书成功！");
        } catch (Exception e) {
            String errMsg = String.format("还书失败,错误原因:%s", e.getMessage());
            System.out.println(errMsg);
        }
    }

    @Test
    public void testFindBorrowerWithLoanList() {
        try {
            String cardno = "259724";
            BorrowerCustom borrowerCustom = itemService.findBorrowerWithLoanList(cardno);
            if (null == borrowerCustom) {
                throw new Exception("未知错误!");
            }
            System.out.println(String.format("借阅号:%s, 姓名:%s, 部门:%s", borrowerCustom.getCardno(), borrowerCustom.getName(), borrowerCustom.getDepartment()));
            System.out.println("列表:");
            for (LoanCustom loan : borrowerCustom.getLoanCustoms()) {
                System.out.println("订单编号:" + loan.getId() + ", 日期:" + loan.getLoanDate() + ", 物品编号:" + loan.getItemCustom().getLibraryCode() + ", 书名:" + loan.getItemCustom().getTitle().getName());
            }
        } catch (Exception e) {
            System.out.println("获取信息失败,错误原因:" + e.getMessage());
        }
    }

    @Test
    public void testLoanItem() {
        try {
            String cardno = "259724";
            String libraryCode = "LIB0001";
            int code;

            code = itemService.loanItem(libraryCode, cardno);
            if (code != 0) {
                throw new Exception("未知错误");
            }
            System.out.println("借书成功！");
        } catch (Exception e) {
            String errMsg = String.format("借阅失败,错误原因:%s", e.getMessage());
            System.out.println(errMsg);
        }
    }

}
