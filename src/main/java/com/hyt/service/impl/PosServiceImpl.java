package com.hyt.service.impl;

import com.hyt.dao.PosDao;
import com.hyt.entity.Pos;
import com.hyt.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("posService")
public class PosServiceImpl implements PosService {

    @Autowired
    private PosDao posDao;

    @Override
    public Integer addPos(Pos pos) {
        return posDao.insertPos(pos);
    }

    @Override
    public Integer updatePos(Pos pos) {
        return posDao.updatePos(pos);
    }

    @Override
    public Integer removePos(Integer posId) {
        return posDao.deletePos(posId);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return posDao.getCount(map);
    }

    @Override
    public List<Pos> findPoss(Map<String, Object> map) {
        return posDao.findPoss(map);
    }
}
