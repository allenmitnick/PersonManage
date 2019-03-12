package com.hyt.dao;

import com.hyt.BaseTest;
import com.hyt.entity.Dept;
import com.hyt.entity.Emp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class DeptDaoTest extends BaseTest {

    @Autowired
    private DeptDao deptDao;

    /**
     * 增加
     */
    @Test
    public void insertDept(){

        Dept dept = new Dept();
        dept.setDeptName("后勤部");
        Integer effectNum = deptDao.insertDept(dept);
        System.out.println("effectNum:" + effectNum);
    }

    /**
     * 删除
     */
    @Test
    public void deleteDept(){

        Integer effectNum = deptDao.deleteDept(4);
        System.out.println("effectNum:" + effectNum);
    }

    /**
     * 更新
     */
    @Test
    public void updateDept(){
        Dept dept = new Dept();
        dept.setDeptId(5);
        dept.setDeptDescription("后勤保障");
        Integer effectNum = deptDao.updateDept(dept);
        System.out.println("effectNum:" + effectNum);
    }

    @Test
    public void testQueryDept(){

        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("deptName","销售");
        List<Dept> deptList = deptDao.findDepts(map);
        for(Dept dept:deptList){
            System.out.println(dept);
        }
    }

    @Test
    public void testGetCount(){

        Integer count = deptDao.getCount(new HashMap<String, Object>());
        System.out.println("count:" +count);
    }


}
