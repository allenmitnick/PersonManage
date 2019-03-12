package com.hyt.service;

import com.hyt.BaseTest;
import com.hyt.entity.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class AdminServiceTest extends BaseTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void testQueryAdmin(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("adminId", 1);
        List<Admin> adminList = adminService.findAdmins(map);
        for(Admin admin:adminList){
            System.out.println(admin);
        }
    }
}
