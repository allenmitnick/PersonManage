package com.hyt.service;

import com.hyt.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    /**
     * 添加部门
     * @param dept
     * @return
     */
    public Integer addDept(Dept dept);

    /**
     * 修改部门
     * @param dept
     * @return
     */
    public Integer updateDept(Dept dept);

    /**
     * 删除部门
     * @param deptId
     * @return
     */
    public Integer removeDept(Integer deptId);

    /**
     * 根据条件查询部门数 【没有条件或者部门id】
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

    /**
     * 根据条件查询出部门 【没有条件或者部门ID 或者部门name】
     * @param map
     * @return
     */
    public List<Dept> findDepts(Map<String, Object> map);


}
