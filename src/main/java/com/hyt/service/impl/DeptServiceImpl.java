package com.hyt.service.impl;

import com.hyt.dao.DeptDao;
import com.hyt.entity.Dept;
import com.hyt.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public Integer addDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public Integer updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    @Override
    public Integer removeDept(Integer deptId) {

        return deptDao.deleteDept(deptId);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return deptDao.getCount(map);
    }

    @Override
    public List<Dept> findDepts(Map<String, Object> map) {
        return deptDao.findDepts(map);
    }
}
