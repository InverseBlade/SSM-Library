package com.zzw.dao;

import com.zzw.BaseTest;
import com.zzw.entity.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemDaoTest extends BaseTest {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testSelectOneByLibraryCode() {
        System.out.println(itemDao.selectOneByLibraryCode("LIB0001"));
    }

    @Test
    public void testUpdateOneLoanInfoById() {
        int id = 3;
        itemDao.updateOneLoanInfoById(id, 8);
        System.out.println(itemDao.selectOneById(id));
    }

    @Test
    public void testInsertOneAndGetId() {
        Item item = new Item();
        item.setLibraryCode("LIB0000");
        item.setTitleId(2);
        item.setmReservation(null);
        itemDao.insertOneAndGetId(item);
        System.out.println(item.getId());
    }

    @Test
    public void testUpdateOneById() {
        Item item = new Item();
        item.setId(1);
        item.setmLoan(null);
        int code = itemDao.updateOneById(item);
        System.out.println(code);
        System.out.println(item.getId());
    }

}
