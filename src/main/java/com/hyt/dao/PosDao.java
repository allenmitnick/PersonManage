package com.hyt.dao;


import com.hyt.entity.Pos;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PosDao {

    /**
     * 添加职位
     * @param pos
     * @return
     */
    public Integer insertPos(Pos pos);

    /**
     * 修改职位
     * @param pos
     * @return
     */
    public Integer updatePos(Pos pos);

    /**
     * 删除职位（根据职位id）
     * @param posId
     * @return
     */
    public Integer deletePos(Integer posId);



    /**
     * 根据条件查询职位
     * @param map
     * @return
     */
    public List<Pos> findPoss(@Param("params") Map<String, Object> map);

    /**
     * 根据条件查询职位数量
     * @param map
     * @return
     */
    public Integer getCount(@Param("params") Map<String, Object> map);


}
