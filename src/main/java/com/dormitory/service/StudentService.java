package com.dormitory.service;

import com.dormitory.pojo.Record;
import com.dormitory.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    //注册（系统管理员，宿舍管理员，学生）

    //学生登录
    public List<Student> studentLogin(String userName,String password);
    //添加学生
    public int addStudentOne(Student student);
    //根据id更新学生
    public int updateStudentById(Student student);
    //根据学生的studentId 显示全部缺寝记录
    public List<Record> selectStudentRecords(Map<Object,Object>map);

    //显示所有学生
    public List<Student> selectAllStudents(Integer pageIndex,Integer pageSize);
    //根据学生的studentid 删除学生
    public int deleteStudentById(Integer studentid);
    //根据宿舍楼dormname和姓名查询学生
    public List<Student> seleteStuByDormBId(Integer pageIndex,Integer pageSize,String dormname,String name);
    //根据id查询学生
    public Student selectStudentById(Integer studentId);
    //根据宿舍楼dormbuildid查询学生
    public List<Student> selectStudentByOne(Integer pageIndex,Integer pageSize,Integer dormbuildid);
    //根据宿舍楼dormname和姓名查询学生
    public List<Student> seleteStuByDormBIdMan(Integer pageIndex,Integer pageSize,Integer dormbuildid,String dormname,String name);
}
