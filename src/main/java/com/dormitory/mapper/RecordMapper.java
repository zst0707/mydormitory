package com.dormitory.mapper;

import com.dormitory.pojo.DoRecord;
import com.dormitory.pojo.Record;
import com.dormitory.pojo.RecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer recordid);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer recordid);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
    //根据学生的studentNum 显示全部缺寝记录
    List<DoRecord> selectRecordsByNum(Map<Object,Object>map);
    //显示全部缺寝记录
    List<DoRecord> selectAllRecords();
    //根据studentname查询记录
    List<DoRecord> selectStudentByName(Map<Object,Object>map);
}