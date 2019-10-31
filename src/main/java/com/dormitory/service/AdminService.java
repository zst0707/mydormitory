package com.dormitory.service;

import com.dormitory.pojo.Admin;

import java.util.List;

public interface AdminService {
    //系统管理员登录
    public List<Admin> adminLogin(String userName, String password);
    //更新系统管理员
    public int updateAdmin(Admin admin);
    //根据adminId查系统管理员
    public Admin selectAdminsById(Integer adminId);
}
