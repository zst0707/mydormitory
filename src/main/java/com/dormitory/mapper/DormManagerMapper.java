package com.dormitory.mapper;

import com.dormitory.pojo.DormManager;
import com.dormitory.pojo.DormManagerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DormManagerMapper {
    long countByExample(DormManagerExample example);

    int deleteByExample(DormManagerExample example);

    int deleteByPrimaryKey(Integer dormmanid);

    int insert(DormManager record);

    int insertSelective(DormManager record);

    List<DormManager> selectByExample(DormManagerExample example);

    DormManager selectByPrimaryKey(Integer dormmanid);

    int updateByExampleSelective(@Param("record") DormManager record, @Param("example") DormManagerExample example);

    int updateByExample(@Param("record") DormManager record, @Param("example") DormManagerExample example);

    int updateByPrimaryKeySelective(DormManager record);

    int updateByPrimaryKey(DormManager record);

//    List<DormManager> selectDormManagerLimit(Map<Object,Object> map);
}