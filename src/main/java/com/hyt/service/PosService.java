package com.hyt.service;

import com.hyt.entity.Pos;

import java.util.List;
import java.util.Map;

public interface PosService {

    /**
     * 添加职位
     * @param pos
     * @return
     */
    public Integer addPos(Pos pos);

    /**
     * 修改职位
     * @param pos
     * @return
     */
    public Integer updatePos(Pos pos);

    /**
     * 删除职位
     * @param posId
     * @return
     */
    public Integer removePos(Integer posId);

    /**
     * 根据条件查询职位数 【没有条件或者职位id】
     * @param map
     * @return
     */
    public Integer getCount(Map<String, Object> map);

    /**
     * 根据条件职位出部门 【没有条件或者职位ID 或者职位name】
     * @param map
     * @return
     */
    public List<Pos> findPoss(Map<String, Object> map);
}
