package com.hyt.dao;


import com.hyt.BaseTest;
import com.hyt.entity.Admin;
import com.hyt.entity.Post;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 必须要继承baseTest 不然AdminDao注入失败
 * 管理员表（1,2,3）  通知表（1）
 * 只有1号管理员发布了通知 如果直接用外连接查询adminId =2 则查询失败 （笛卡尔积 过滤两边条件不相同的）
 *
 * 1.public Integer insertAdmin(Admin admin);
 * 2.public Integer updateAdmin(Admin admin);
 * 3.public Integer deleteAdmin(Integer adminId);
 * 4.public Admin login(Admin admin);
 * 5.public List<Admin> findAdmins(Map<String, Object> map);
 * 6.public Integer getCount(@Param("params") Map<String, Object> map);
 */
public class AdminDaoTest extends BaseTest {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private PostDao postDao;

    /**
     * 增加
     */
    @Test
    public void testInsertAdmin(){

        Admin admin = new Admin("hyt", "hyt",null);
        Integer effectNum = adminDao.insertAdmin(admin);
        System.out.println("effectNum:" +effectNum);

    }

    /**
     * 删除
     */
    @Test
    public void testDeleteAdmin(){

        Integer effectNum = adminDao.deleteAdmin(6);
        System.out.println("effectNum:" +effectNum);
    }


    @Test
    public void testUpdateAdmin(){

        Admin admin = new Admin();
        admin.setAdminId(5);
        admin.setUsername("胡永涛");
        admin.setPassword("胡永涛");
        Integer effectNum = adminDao.updateAdmin(admin);
        System.out.println("effectNum:" +effectNum);

    }

    /**
     * 条件查询
     * 可以通过用户名或者用户id
     */
    @Test
    public void testQueryAdmin(){
        Map<String, Object> map = new HashMap<String, Object>();
        //map里放入的也是entity的属性
        map.put("adminId", 4);
        map.put("username", "hyt");

        List<Admin> adminList = adminDao.findAdmins(map);

        for(Admin admin:adminList){
            System.out.println(admin);

        }

    }

    /**
     * 能否登陆
     */
    @Test
    public void testLogin(){

        Admin admin = new Admin();
        admin.setUsername("hyt");
        admin.setPassword("hyt");
        Admin loginAdmin = adminDao.login(admin);
        System.out.println("loginAdmin:" + loginAdmin);
    }

    /**
     * 通过条件查询总数
     */
    @Test
    public void testGetCount(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "hyt");
        Integer count = adminDao.getCount(map);
        System.out.println("count:" + count);

    }



}
