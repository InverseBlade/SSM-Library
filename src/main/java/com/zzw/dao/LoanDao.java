package com.zzw.dao;

import com.zzw.entity.Loan;
import com.zzw.entity.custom.LoanCustom;
import com.zzw.entity.custom.LoanListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoanDao {

    int insertOneAndGetId(Loan loan);

    Loan selectOneById(Integer id);

    List<Loan> selectListByBorrowerId(@Param("borrowerId") Integer borrowerId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取借阅者所有正在借阅的信息列表
     *
     * @param borrowerId 借阅者主键
     * @return 借阅信息列表
     */
    List<LoanListVO> selectBorrowingByBorrowerId(@Param("borrowerId") Integer borrowerId);

}
