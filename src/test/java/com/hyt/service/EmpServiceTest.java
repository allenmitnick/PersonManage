package com.hyt.service;

import com.hyt.BaseTest;
import com.hyt.entity.Emp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class EmpServiceTest extends BaseTest {
    @Autowired
    private EmpService empService;

    @Test
    public void testQueryDept(){

        HashMap<String, Object> map = new HashMap<>();
//        map.put("empId", 1);
        List<Emp> empList = empService.findEmps(map);
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
}
