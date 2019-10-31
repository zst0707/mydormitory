package com.dormitory.service.impl;

import com.dormitory.mapper.RecordMapper;
import com.dormitory.pojo.DoRecord;
import com.dormitory.pojo.Record;
import com.dormitory.pojo.RecordExample;
import com.dormitory.service.RecordService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordDao;

    @Override
    public List<DoRecord> selectAllRecords(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        return recordDao.selectAllRecords();
    }

    @Override
    public int deleteRecordByid(Integer recordid) {
        return recordDao.deleteByPrimaryKey(recordid);
    }

    @Override
    public int insertRecord(Record record) {
        return recordDao.insert(record);
    }

    @Override
    public List<DoRecord> selectStudentByNum(Integer pageIndex, Integer pageSize, String studentnumber) {
        Map<Object,Object> map=new HashMap<>();
        map.put("studentnumber",studentnumber);
        PageHelper.startPage(pageIndex,pageSize);
        if(studentnumber==""){
            return recordDao.selectAllRecords();
        }
        return recordDao.selectRecordsByNum(map);
    }

    @Override
    public List<DoRecord> selectStudentByName(Integer pageIndex, Integer pageSize, String studentname) {
        Map<Object,Object> map=new HashMap<>();
        map.put("studentname",studentname);
        PageHelper.startPage(pageIndex,pageSize);
        return recordDao.selectStudentByName(map);
    }

}
