package com.hyt.service;

import com.hyt.BaseTest;
import com.hyt.entity.Dept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class DeptServiceTest extends BaseTest {
    @Autowired
    private DeptService deptService;

    @Test
    public void testQueryDept(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("deptId", 1);
        List<Dept> deptList = deptService.findDepts(map);
        for(Dept dept:deptList){
            System.out.println(dept);
        }
    }
}
