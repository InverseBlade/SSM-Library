package com.zzw.dao;

import com.zzw.entity.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleDao {

    int insertOneAndGetId(Title title);

    Title selectOneById(Integer id);

    int updateOneByIdSelective(Title title);

    List<Title> selectListByPaging(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
