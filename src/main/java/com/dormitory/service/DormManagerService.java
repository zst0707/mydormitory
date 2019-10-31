package com.dormitory.service;

import com.dormitory.pojo.DormManager;

import java.util.List;

public interface DormManagerService {
    //宿舍管理员登录
    public List<DormManager> dormManagerLogin(String userName, String password);
    //显示所有宿舍管理员
    public List<DormManager> selectAllDormMans(Integer pageIndex,Integer pageSize);
    //根据宿舍楼号码查询宿舍管理员
    public List<DormManager> selectDormsByDormId(Integer pageIndex,Integer pageSize,Integer dormbuildid);
    //根据宿舍管理员id删除宿舍管理员
    public int deleteDormsById(Integer dormmanid);
    //更新宿舍管理员
    public int updateDorms(DormManager dormManager);
    //根据id查询宿舍管理员
    public DormManager selectDormByid(Integer dormmanid);
}
