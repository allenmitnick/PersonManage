package com.hyt.dao;

import com.hyt.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminDao {

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public Integer insertAdmin(Admin admin);

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    public Integer updateAdmin(Admin admin);

    /**
     * 删除管理员（根据管理员id）
     * @param adminId
     * @return
     */
    public Integer deleteAdmin(Integer adminId);

    /**
     * 登录
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

    /**
     * 根据条件查询管理员
     * @param map
     * @return
     */
    public List<Admin> findAdmins(@Param("params") Map<String, Object> map);

    /**
     * 根据条件查询管理员人数
     * @param map
     * @return
     */
    public Integer getCount(@Param("params") Map<String, Object> map);
}
