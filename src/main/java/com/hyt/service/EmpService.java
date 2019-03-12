package com.hyt.service;

import com.hyt.entity.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {

    /**
     * 添加员工
     * @param emp
     * @return
     */
    public Integer addEmp(Emp emp);

    /**
     * 修改员工
     * @param emp
     * @return
     */
    public Integer updateEmp(Emp emp);

    /**
     * 删除员工
     * @param empId
     * @return
     */
    public Integer removeEmp(Integer empId);

    /**
     * 根据条件查询员工数 【没有条件或者员工id】
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

    /**
     * 根据条件查询出员工 【没有条件或者员工ID 或者员工name】
     * @param map
     * @return
     */
    public List<Emp> findEmps(Map<String, Object> map);
}
