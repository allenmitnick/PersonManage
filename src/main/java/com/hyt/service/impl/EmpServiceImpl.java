package com.hyt.service.impl;

import com.hyt.dao.EmpDao;
import com.hyt.entity.Emp;
import com.hyt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public Integer addEmp(Emp emp) {
        return empDao.insertEmp(emp);
    }

    @Override
    public Integer updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public Integer removeEmp(Integer empId) {
        return empDao.deleteEmp(empId);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return empDao.getCount(map);
    }

    @Override
    public List<Emp> findEmps(Map<String, Object> map) {
        return empDao.findEmps(map);
    }

}
