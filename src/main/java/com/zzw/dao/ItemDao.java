package com.zzw.dao;

import com.zzw.entity.Item;
import org.apache.ibatis.annotations.Param;

public interface ItemDao {

    int insertOneAndGetId(Item item);

    Item selectOneById(Integer id);

    Item selectOneByLibraryCode(String libraryCode);

    int updateOneById(Item item);

    int updateOneLoanInfoById(@Param("id") Integer id, @Param("mLoan") Integer mLoan);

    int updateOneReservationInfoById(@Param("id") Integer id, @Param("mReservation") Integer mReservation);

    int updateOneLoseInfoById(@Param("id") Integer id, @Param("mLoseBook") Integer mLoseBook);


}
