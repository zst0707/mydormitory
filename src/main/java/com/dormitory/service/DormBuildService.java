package com.dormitory.service;

import com.dormitory.pojo.DormBuild;

import java.util.List;

public interface DormBuildService {
    //显示所有宿舍楼
    public List<DormBuild> selectAllDormBuilds(Integer pageIndex,Integer pageSize);
    //根据宿舍楼id删除宿舍
    public int deleteDormBuild(Integer dormbuildid);
    //根据宿舍楼id查找宿舍
    public List<DormBuild> selectBuildByid(Integer pageIndex,Integer pageSize,Integer dormbuildid);
    //新增宿舍楼
    public int insertBuild(DormBuild dormBuild);
}
