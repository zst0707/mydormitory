package com.dormitory.mapper;

import com.dormitory.pojo.Dorm;
import com.dormitory.pojo.DormExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormMapper {
    long countByExample(DormExample example);

    int deleteByExample(DormExample example);

    int deleteByPrimaryKey(Integer dormid);

    int insert(Dorm record);

    int insertSelective(Dorm record);

    List<Dorm> selectByExample(DormExample example);

    Dorm selectByPrimaryKey(Integer dormid);

    int updateByExampleSelective(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByExample(@Param("record") Dorm record, @Param("example") DormExample example);

    int updateByPrimaryKeySelective(Dorm record);

    int updateByPrimaryKey(Dorm record);
}