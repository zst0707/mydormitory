package com.dormitory.service.impl;

import com.dormitory.mapper.AdminMapper;
import com.dormitory.pojo.Admin;
import com.dormitory.pojo.AdminExample;
import com.dormitory.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminDao;

    @Override
    public List<Admin> adminLogin(String userName, String password) {
        AdminExample ae=new AdminExample();
        AdminExample.Criteria criteria=ae.createCriteria();
        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        return adminDao.selectByExample(ae);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateByPrimaryKeySelective(admin);
    }

    @Override
    public Admin selectAdminsById(Integer adminId) {
        return adminDao.selectByPrimaryKey(adminId);
    }
}
