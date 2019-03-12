package com.hyt.dao;



import com.hyt.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface DeptDao {

    /**
     * 添加部门
     * @param dept
     * @return
     */
    public Integer insertDept(Dept dept);

    /**
     * 修改部门
     * @param dept
     * @return
     */
    public Integer updateDept(Dept dept);

    /**
     * 删除部门（根据部门id）
     * @param deptId
     * @return
     */
    public Integer deleteDept(Integer deptId);



    /**
     * 根据条件查询部门
     * @param map
     * @return
     */
    public List<Dept> findDepts(@Param("params") Map<String, Object> map);

    /**
     * 根据条件查询部门数量
     * @param map
     * @return
     */
    public Integer getCount(@Param("params") Map<String, Object> map);


}
