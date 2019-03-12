package com.hyt.dao;

import com.hyt.BaseTest;
import com.hyt.entity.Dept;
import com.hyt.entity.Emp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class EmpDaoTest extends BaseTest {

    @Autowired
    private EmpDao empDao;
    @Autowired
    private DeptDao deptDao;

    @Test
    public void testInsertEmp(){

        Emp emp = new Emp();
        emp.setEmpId(1006);
        emp.setEmpName("严志伟");
        emp.setSex("男");
        emp.setPhone("15555892630");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {

            date = df.parse("1994-3-2 12:21:21");
        }catch (Exception e){
            throw new RuntimeException("时间格式不对");
        }

        emp.setBirthday(date);

        Dept dept = new Dept();
        dept.setDeptId(10);
        //不可少了这一步 将emp的属性值或属性的属性值赋给变量
        emp.setEmpDept(dept);

        Integer effectNum = empDao.insertEmp(emp);
        System.out.println("effectNum:" +effectNum);


    }

    @Test
    public void testDeleteEmp(){

        //如果没有这个id的行 则删除失败 返回0
        Integer effectNum = empDao.deleteEmp(1006);
        System.out.println("effectNum:" +effectNum);
    }

    /**
     * 这个修改方式不太人性化
     * 1.如果mysql里某个列不允许为空 而对象未赋值则修改失败
     * 2.所有属性都被修改
     * 一般适用于查询出某个对象然后修改某些属性
     * 解决方案：
     * 在mybatis里用 set if子句
     */
    @Test
    public void testUpdateEmp(){

        Emp emp = new Emp();
        emp.setEmpId(1006);
        emp.setEmpName("严志伟11");
        emp.setSex("男");
        emp.setPhone("15555892630");
        Integer effectNum = empDao.updateEmp(emp);
        System.out.println("effectNum:" +effectNum);
    }

    /**
     * 正常是通过empId 或者empName 查询
     * 实现了通过 职位或部门查询 只需要map里传递 deptId 或者posId  即可查询出所属的所有员工
     * 但是感觉还有一点不完善
     */
    @Test
    public void testQueryEmp(){

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("deptId", 7);
        List<Emp> empList = empDao.findEmps(map);
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }

    @Test
    public void testGetCount(){

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("deptId", 2);

        Integer count = empDao.getCount(map);
        System.out.println("count:" + count);

    }
}
