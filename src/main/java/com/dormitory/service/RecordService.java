package com.dormitory.service;

import com.dormitory.pojo.DoRecord;
import com.dormitory.pojo.Record;

import java.util.List;

public interface RecordService {
    //显示全部记录
    public List<DoRecord> selectAllRecords(Integer pageIndex, Integer pageSize);
    //根据recordid删除记录
    public int deleteRecordByid(Integer recordid);
    //新增记录
    public int insertRecord(Record record);
    //根据studentnum查询记录
    public List<DoRecord> selectStudentByNum(Integer pageIndex, Integer pageSize,String studentnumber);
    //根据学生姓名查询记录
    public List<DoRecord> selectStudentByName(Integer pageIndex, Integer pageSize,String studentname);
}
