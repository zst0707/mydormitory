package com.dormitory.service.impl;

import com.dormitory.mapper.DormBuildMapper;
import com.dormitory.pojo.DormBuild;
import com.dormitory.pojo.DormBuildExample;
import com.dormitory.service.DormBuildService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormBuildServiceImpl implements DormBuildService {
    @Autowired
    public DormBuildMapper dormBuildDao;

    //显示所有宿舍楼
    @Override
    public List<DormBuild> selectAllDormBuilds(Integer pageIndex,Integer pageSize) {
        DormBuildExample dbe=new DormBuildExample();
        DormBuildExample.Criteria criteria=dbe.createCriteria();
        criteria.andDormbuildidIsNotNull();
        PageHelper.startPage(pageIndex,pageSize);
        return dormBuildDao.selectByExample(dbe);
    }

    @Override
    public int deleteDormBuild(Integer dormbuildid) {
        return dormBuildDao.deleteByPrimaryKey(dormbuildid);
    }

    @Override
    public List<DormBuild> selectBuildByid(Integer pageIndex,Integer pageSize,Integer dormbuildid) {
        DormBuildExample dbe=new DormBuildExample();
        DormBuildExample.Criteria criteria=dbe.createCriteria();
        if(dormbuildid!=null){
            criteria.andDormbuildidEqualTo(dormbuildid);
        }else {
            criteria.andDormbuildidIsNotNull();
        }
        PageHelper.startPage(pageIndex,pageSize);
        return dormBuildDao.selectByExample(dbe);
    }

    @Override
    public int insertBuild(DormBuild dormBuild) {
        return dormBuildDao.insert(dormBuild);
    }
}
