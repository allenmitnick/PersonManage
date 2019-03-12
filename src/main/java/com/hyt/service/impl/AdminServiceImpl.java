package com.hyt.service.impl;

import com.hyt.dao.AdminDao;
import com.hyt.entity.Admin;
import com.hyt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    /**
     * 成功返回1 否则返回0
     * @param admin
     * @return
     */
    @Override
    public Integer addAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }

    /**
     * 成功返回1 否则返回0
     * @param admin
     * @return
     */
    @Override
    public Integer updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    /**
     * 成功返回1 否则返回0
     * @param adminId
     * @return
     */
    @Override
    public Integer removeAdmin(Integer adminId) {
        return null;
    }

    @Override
    public List<Admin> findAdmins(Map<String, Object> map) {
        return adminDao.findAdmins(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return adminDao.getCount(map);
    }
}
