package com.dormitory.service.impl;

import com.dormitory.mapper.StudentMapper;
import com.dormitory.pojo.Record;
import com.dormitory.pojo.Student;
import com.dormitory.pojo.StudentExample;
import com.dormitory.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentDao;

    //学生登录
    @Override
    public List<Student> studentLogin(String userName,String password) {
        StudentExample se=new StudentExample();
        StudentExample.Criteria criteria = se.createCriteria();
        criteria.andNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        return studentDao.selectByExample(se);

    }

    //添加学生
    @Override
    public int addStudentOne(Student student) {
        return studentDao.insert(student);
    }

    //根据id查询学生
    @Override
    public Student selectStudentById(Integer studentId) {
        return  studentDao.selectByPrimaryKey(studentId);
    }

    @Override
    public List<Student> selectStudentByOne(Integer pageIndex, Integer pageSize, Integer dormbuildid) {
        PageHelper.startPage(pageIndex,pageSize);
        StudentExample se=new StudentExample();
        StudentExample.Criteria criteria=se.createCriteria();
        criteria.andDormbuildidEqualTo(dormbuildid);
        return studentDao.selectByExample(se);
    }

    @Override
    public List<Student> seleteStuByDormBIdMan(Integer pageIndex, Integer pageSize,Integer dormbuildid,
                                               String dormname, String name) {
        StudentExample se=new StudentExample();
        StudentExample.Criteria criteria=se.createCriteria();
        criteria.andDormnameLike("%"+dormname+"%");
        criteria.andDormbuildidEqualTo(dormbuildid);
        criteria.andNameLike("%"+name+"%");
        PageHelper.startPage(pageIndex,pageSize);
        return studentDao.selectByExample(se);

    }

    //根据id更新学生
    @Override
    public int updateStudentById(Student student) {
        return studentDao.updateByPrimaryKeySelective(student);
    }

    //根据学生的studentId 显示全部缺寝记录
    @Override
    public List<Record> selectStudentRecords(Map<Object, Object> map) {
        return null;
    }

    //显示所有学生
    @Override
    public List<Student> selectAllStudents(Integer pageIndex, Integer pageSize) {
        StudentExample se=new StudentExample();
        StudentExample.Criteria criteria=se.createCriteria();
        criteria.andNameIsNotNull();
        PageHelper.startPage(pageIndex,pageSize);
        return studentDao.selectByExample(se);
    }

    @Override
    public int deleteStudentById(Integer studentid) {
        return studentDao.deleteByPrimaryKey(studentid);
    }

    @Override
    public List<Student> seleteStuByDormBId(Integer pageIndex, Integer pageSize,
                                            String dormname,String name) {
        StudentExample se=new StudentExample();
        StudentExample.Criteria criteria=se.createCriteria();
        criteria.andDormnameLike("%"+dormname+"%");
        criteria.andNameLike("%"+name+"%");
        PageHelper.startPage(pageIndex,pageSize);
        return studentDao.selectByExample(se);
    }
}
