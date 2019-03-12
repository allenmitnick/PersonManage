package com.hyt.service;

import com.hyt.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {

    /**
     * 1.管理员登录
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

    /**
     * 2.添加管理员
     * @param admin
     * @return
     */
    public Integer addAdmin(Admin admin);

    /**
     * 3.修改管理员
     * @param admin
     * @return
     */
    public Integer updateAdmin(Admin admin);

    /**
     * 4.删除管理员（根据管理员ID）
     * @param adminId
     * @return
     */
    public Integer removeAdmin(Integer adminId);

    /**
     * 5.根据条件查询出管理员 【没有条件或者管理员ID 或者管理员username】
     * @param map
     * @return
     */
    public List<Admin> findAdmins(Map<String, Object> map);

    /**
     * 6.根据条件查询管理员人数 【没有条件或者管理员username】
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

}
