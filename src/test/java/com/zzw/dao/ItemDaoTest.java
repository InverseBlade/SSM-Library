package com.zzw.dao;

import com.zzw.BaseTest;
import com.zzw.entity.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemDaoTest extends BaseTest {

    @Autowired
    private ItemDao itemDao;

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
        item.setId(5);
        int code = itemDao.updateOneById(item);
        System.out.println(code);
        System.out.println(item.getId());
    }

}
