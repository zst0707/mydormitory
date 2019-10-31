package com.dormitory.service.impl;

import com.dormitory.mapper.DormManagerMapper;
import com.dormitory.pojo.DormManager;
import com.dormitory.pojo.DormManagerExample;
import com.dormitory.service.DormManagerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormManagerServiceImpl implements DormManagerService {
    @Autowired
    private DormManagerMapper dormManagerDao;

    @Override
    public List<DormManager> dormManagerLogin(String userName, String password) {
        DormManagerExample dam=new DormManagerExample();
        DormManagerExample.Criteria criteria=dam.createCriteria();
        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        return dormManagerDao.selectByExample(dam);
    }

    @Override
    public List<DormManager> selectAllDormMans(Integer pageIndex,Integer pageSize) {
        DormManagerExample dam=new DormManagerExample();
        DormManagerExample.Criteria criteria=dam.createCriteria();
        criteria.andUsernameIsNotNull();
        PageHelper.startPage(pageIndex,pageSize);
        return dormManagerDao.selectByExample(dam);
    }

    @Override
    public List<DormManager> selectDormsByDormId(Integer pageIndex,Integer pageSize,Integer dormbuildid) {
        DormManagerExample dme=new DormManagerExample();
        DormManagerExample.Criteria criteria=dme.createCriteria();
        if(dormbuildid!=null){
            criteria.andDormbuildidEqualTo(dormbuildid);
        }else{
            criteria.andUsernameIsNotNull();
        }

        PageHelper.startPage(pageIndex,pageSize);
        return dormManagerDao.selectByExample(dme);
    }

    @Override
    public int deleteDormsById(Integer dormmanid) {
        return dormManagerDao.deleteByPrimaryKey(dormmanid);
    }

    @Override
    public int updateDorms(DormManager dormManager) {
        return dormManagerDao.updateByPrimaryKeySelective(dormManager);
    }

    @Override
    public DormManager selectDormByid(Integer dormmanid) {

        return dormManagerDao.selectByPrimaryKey(dormmanid);
    }


}
