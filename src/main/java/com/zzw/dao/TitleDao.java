package com.zzw.dao;

import com.zzw.entity.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleDao {

    int insertOneAndGetId(Title title) throws Exception;

    Title selectOneById(Integer id) throws Exception;

    int updateOneByIdSelective(Title title) throws Exception;

    List<Title> selectListByPaging(@Param("offset") Integer offset, @Param("limit") Integer limit) throws Exception;

}
