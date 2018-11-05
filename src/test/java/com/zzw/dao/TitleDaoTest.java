package com.zzw.dao;

import com.zzw.BaseTest;
import com.zzw.entity.Title;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TitleDaoTest extends BaseTest {

    @Autowired
    private TitleDao titleDao;

    @Test
    public void testSelectListByPaging() throws Exception {
        List<Title> titleList = titleDao.selectListByPaging(0, 50);
        for (Title title : titleList) {
            System.out.println(title);
        }
    }

    @Test
    public void testInsertOneAndGetId() throws Exception {
        Title title = new Title();
        title.setName("测试书籍");
        title.setAuthor("张泽威");
        title.setPrice(100.5);
        title.setTotalNumber(30);
        title.setType("MAGAZINE");
        title.setIsbn("");
        titleDao.insertOneAndGetId(title);
        System.out.println(titleDao.selectOneById(title.getId()));
    }


    @Test
    public void testUpdateOneByIdSelective() throws Exception {
        Title title = titleDao.selectOneById(3);
        title.setBorrowedNumber(title.getBorrowedNumber() + 1);
        System.out.println(titleDao.updateOneByIdSelective(title));
        System.out.println(titleDao.selectOneById(title.getId()));
    }
}
