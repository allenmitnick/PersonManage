package com.hyt.dao;

import com.hyt.entity.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmpDao {

    /**
     * 添加员工
     * @param emp
     * @return
     */
    public Integer insertEmp(Emp emp);

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
    public Integer deleteEmp(Integer empId);

    /**
     * 根据条件查询员工
     * @param map
     * @return
     */
    public List<Emp> findEmps(@Param("params") Map<String, Object> map);

    /**
     * 根据条件查询员人数
     * @param map
     * @return
     */
    public Integer getCount(@Param("params") Map<String, Object> map);


}
