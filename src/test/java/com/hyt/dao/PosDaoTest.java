package com.hyt.dao;

import com.hyt.BaseTest;
import com.hyt.entity.Pos;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class PosDaoTest extends BaseTest {

    @Autowired
    private PosDao posDao;

    /**
     * 增加
     */
    @Test
    public void insertPos(){

        Pos pos = new Pos();
        pos.setPosName("后台工程师");
        pos.setPosDescription("写后台程序");
        Integer effectNum = posDao.insertPos(pos);
        System.out.println("effectNum:" + effectNum);
    }

    /**
     * 删除
     */
    @Test
    public void deletePos(){

        Integer effectNum = posDao.deletePos(5);
        System.out.println("effectNum:" + effectNum);
    }

    /**
     * 更新
     */
    @Test
    public void updatePos(){
        Pos pos = new Pos();
        pos.setPosId(6);
        pos.setPosDescription("写后台程序hh");
        Integer effectNum = posDao.updatePos(pos);
        System.out.println("effectNum:" + effectNum);
    }

    @Test
    public void testQueryPos(){

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("posId",1);
        List<Pos> posList = posDao.findPoss(map);
        for(Pos pos:posList){
            System.out.println(pos);
        }
    }

    @Test
    public void testGetCount(){

        Integer count = posDao.getCount(new HashMap<String, Object>());
        System.out.println("count:" +count);
    }


}
