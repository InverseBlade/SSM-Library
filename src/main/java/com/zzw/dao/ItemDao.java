package com.zzw.dao;

import com.zzw.entity.Item;
import org.apache.ibatis.annotations.Param;

public interface ItemDao {

    int insertOneAndGetId(Item item) throws Exception;

    Item selectOneById(Integer id) throws Exception;

    Item selectOneByLibraryCode(String libraryCode) throws Exception;

    int updateOneById(Item item) throws Exception;

    int updateOneLoanInfoById(@Param("id") Integer id, @Param("mLoan") Integer mLoan) throws Exception;

    int updateOneReservationInfoById(@Param("id") Integer id, @Param("mReservation") Integer mReservation) throws Exception;

    int updateOneLoseInfoById(@Param("id") Integer id, @Param("mLoseBook") Integer mLoseBook) throws Exception;


}
