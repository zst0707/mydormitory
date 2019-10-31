package com.dormitory.mapper;

import com.dormitory.pojo.DormBuild;
import com.dormitory.pojo.DormBuildExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormBuildMapper {
    long countByExample(DormBuildExample example);

    int deleteByExample(DormBuildExample example);

    int deleteByPrimaryKey(Integer dormbuildid);

    int insert(DormBuild record);

    int insertSelective(DormBuild record);

    List<DormBuild> selectByExample(DormBuildExample example);

    DormBuild selectByPrimaryKey(Integer dormbuildid);

    int updateByExampleSelective(@Param("record") DormBuild record, @Param("example") DormBuildExample example);

    int updateByExample(@Param("record") DormBuild record, @Param("example") DormBuildExample example);

    int updateByPrimaryKeySelective(DormBuild record);

    int updateByPrimaryKey(DormBuild record);
}